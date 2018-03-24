package com.elsys.easybooker.services;

import com.elsys.easybooker.dtos.BusinessDTOPrevious;
import com.elsys.easybooker.dtos.business.BusinessBriefDTO;
import com.elsys.easybooker.dtos.locations.LocationBriefDTO;
import com.elsys.easybooker.dtos.locations.LocationDTO;
import com.elsys.easybooker.dtos.locations.LocationUpdateDTO;
import com.elsys.easybooker.models.*;
import com.elsys.easybooker.repositories.LocationRepository;
import com.elsys.easybooker.repositories.ServiceRepository;
import com.elsys.easybooker.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedClientException;

import java.util.ArrayList;
import java.util.List;

import static com.elsys.easybooker.security.SecurityConstants.ADMIN;

@org.springframework.stereotype.Service
public class LocationService {
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

    public void deleteLocationById(long locationId){
        if(isUserBusinessAdmin(locationRepository.findById(locationId).getBusiness().getId())){
            locationRepository.delete(locationId);
        }
    }

    public List<Service> getServicesForLocation(long locationId) {
        return locationRepository.findById(locationId).getServices();

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
