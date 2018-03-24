package com.elsys.easybooker.services;

import com.elsys.easybooker.dtos.BusinessDTO;
import com.elsys.easybooker.dtos.LocationDTO;
import com.elsys.easybooker.dtos.ServiceDTO;
import com.elsys.easybooker.models.Business;
import com.elsys.easybooker.models.DaySchedule;
import com.elsys.easybooker.models.Location;
import com.elsys.easybooker.models.Service;
import com.elsys.easybooker.repositories.LocationRepository;
import com.elsys.easybooker.repositories.ServiceRepository;
import org.postgresql.util.PGInterval;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class LocationService {
    private final ServiceRepository serviceRepository;
    private final LocationRepository locationRepository;

    public LocationService(
                           ServiceRepository serviceRepository,
                           LocationRepository locationRepository){
        this.serviceRepository = serviceRepository;
        this.locationRepository = locationRepository;
    }

    public Iterable getLocations() {
        return locationRepository.findAll();
    }

    public Location getLocationById(long locationId){
        return locationRepository.findById(locationId);
    }

    public BusinessDTO getBusinessForLocation(long locationId){
        Location location = locationRepository.findById(locationId);
        Business business = location.getBusiness();
        BusinessDTO businessDTO = new BusinessDTO();
        businessDTO.setId(business.getId());
        businessDTO.setName(business.getName());
        businessDTO.setDescription(business.getDescription());
        businessDTO.setEmail(business.getEmail());

        return businessDTO;

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


}
