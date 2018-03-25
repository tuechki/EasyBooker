package com.elsys.easybooker.services;

import com.elsys.easybooker.dtos.business.BusinessBriefDTO;
import com.elsys.easybooker.dtos.location.LocationBriefDTO;
import com.elsys.easybooker.dtos.location.LocationDTO;
import com.elsys.easybooker.dtos.location.LocationUpdateDTO;
import com.elsys.easybooker.dtos.service.ServiceBriefDTO;
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
public class LocationService {

    private final Path rootLocationImagesLocation = Paths.get("src\\main\\resources\\static\\images\\locations");
    private final ServiceRepository serviceRepository;
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public LocationService(
                           ServiceRepository serviceRepository,
                           LocationRepository locationRepository,
                           UserRepository userRepository){
        this.serviceRepository = serviceRepository;
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
    }

    public List<LocationBriefDTO> getLocations() {

        List<LocationBriefDTO> locationBriefDTOList = new ArrayList<>();
        for( Location location : locationRepository.findAll()){
            locationBriefDTOList.add(modelMapper.map(location, LocationBriefDTO.class));
        }

        return locationBriefDTOList;
    }

    public LocationDTO getLocationById(long locationId){
        return modelMapper.map(locationRepository.findById(locationId), LocationDTO.class);
    }

    public BusinessBriefDTO getBusinessForLocation(long locationId){
        Location location = locationRepository.findById(locationId);
        return modelMapper.map(location.getBusiness(), BusinessBriefDTO.class);
    }

    public LocationBriefDTO updateLocationById(LocationUpdateDTO locationUpdateDTO){
        Location location = modelMapper.map(locationUpdateDTO, Location.class);
        if(isUserBusinessAdmin(location.getBusiness().getId())){
            locationRepository.save(location);
        }

        return modelMapper.map(location, LocationBriefDTO.class);
    }

    public void addImageToLocation(long locationId, MultipartFile image) throws IOException {

        String imageName = "image";
        String imageExtension = ".png";

        new File(this.rootLocationImagesLocation.toString() + "/" + locationId ).mkdirs();
        Files.copy(image.getInputStream(), this.rootLocationImagesLocation.resolve( locationId + "/" + imageName + imageExtension));
    }

    public void deleteLocationById(long locationId){
        if(isUserBusinessAdmin(locationRepository.findById(locationId).getBusiness().getId())){
            locationRepository.delete(locationId);
        }
    }

    public List<ServiceBriefDTO> getServicesForLocation(long locationId) {
        List<ServiceBriefDTO> serviceBriefDTOList = new ArrayList<>();
        for (Service service : locationRepository.findById(locationId).getServices()){
            serviceBriefDTOList.add(modelMapper.map(service, ServiceBriefDTO.class));
        }

        return serviceBriefDTOList;
    }

    public void addServicesToLocation(long locationId, List<Long> serviceIds) {

        Location location = locationRepository.findById(locationId);
        List<Service> servicesForLocation = new ArrayList<>();

        for(Long serviceId : serviceIds){
          Service service = serviceRepository.findById(serviceId);
          service.getLocations().add(location);
          servicesForLocation.add(service);
        }

        location.setServices(servicesForLocation);
        locationRepository.save(location);

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
