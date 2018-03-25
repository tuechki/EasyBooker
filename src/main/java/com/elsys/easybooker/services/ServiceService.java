package com.elsys.easybooker.services;

import com.elsys.easybooker.dtos.business.BusinessBriefDTO;
import com.elsys.easybooker.dtos.location.LocationBriefDTO;
import com.elsys.easybooker.dtos.service.ServiceBriefDTO;
import com.elsys.easybooker.dtos.service.ServiceDTO;
import com.elsys.easybooker.dtos.service.ServiceUpdateDTO;
import com.elsys.easybooker.models.*;
import com.elsys.easybooker.repositories.LocationRepository;
import com.elsys.easybooker.repositories.ServiceRepository;
import com.elsys.easybooker.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedClientException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.elsys.easybooker.security.SecurityConstants.ADMIN;

@org.springframework.stereotype.Service
public class ServiceService {

    private final Path rootServiceImagesLocation = Paths.get("src\\main\\resources\\static\\images\\services");
    private final ServiceRepository serviceRepository;
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public ServiceService(
            ServiceRepository serviceRepository,
            LocationRepository locationRepository,
            UserRepository userRepository){

        this.serviceRepository = serviceRepository;
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
    }


    public List<ServiceBriefDTO> getServices(){
        List<ServiceBriefDTO> serviceBriefDTOList = new ArrayList<>();
        for( Service service : serviceRepository.findAll()){
            serviceBriefDTOList.add(modelMapper.map(service, ServiceBriefDTO.class));
        }

        return serviceBriefDTOList;
    }

    public ServiceDTO getServiceById(long serviceId){
        return modelMapper.map(serviceRepository.findById(serviceId), ServiceDTO.class);
    }

    public List<LocationBriefDTO> getLocationsForService(long serviceId){
        List<LocationBriefDTO> locationBriefDTOList = new ArrayList<>();
        for( Location location : serviceRepository.findById(serviceId).getLocations()){
            locationBriefDTOList.add(modelMapper.map(location, LocationBriefDTO.class));
        }

        return locationBriefDTOList;
    }

    public BusinessBriefDTO getBusinessForService(long serviceId){
        Service service = serviceRepository.findById(serviceId);
        return modelMapper.map(service.getBusiness(), BusinessBriefDTO.class);
    }


    public ServiceBriefDTO updateServiceById(ServiceUpdateDTO serviceUpdateDTO){
        Service service = modelMapper.map(serviceUpdateDTO, Service.class);
        if(isUserBusinessAdmin(service.getBusiness().getId())){
            serviceRepository.save(service);
        }

        return modelMapper.map(service, ServiceBriefDTO.class);
    }

    public void addImageToService(long serviceId, MultipartFile image) throws IOException {

        String imageName = "image";
        String imageExtension = ".png";

        new File(this.rootServiceImagesLocation.toString() + "/" + serviceId ).mkdirs();
        Files.copy(image.getInputStream(), this.rootServiceImagesLocation.resolve( serviceId + "/" + imageName + imageExtension));
    }

    public void deleteServiceById(long serviceId){
        if(isUserBusinessAdmin(serviceRepository.findById(serviceId).getBusiness().getId())){
            locationRepository.delete(serviceId);
        }
    }


    public boolean isUserBusinessAdmin(long businessId) throws UnauthorizedClientException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(auth.getName());

        for(UserBusiness userBusiness : user.getBusinessAssoc()){
            if(userBusiness.getBusiness().getId() == businessId
                    && userBusiness.getPermission() == ADMIN){
                return true;
            }
        }

        throw new UnauthorizedClientException("No permissions for requested operation.");
    }
}
