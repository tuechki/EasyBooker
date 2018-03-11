package com.elsys.easybooker.services;

import com.elsys.easybooker.dtos.LocationDTO;
import com.elsys.easybooker.dtos.ServiceDTO;
import com.elsys.easybooker.models.Location;
import com.elsys.easybooker.models.Service;
import com.elsys.easybooker.repositories.LocationRepository;
import com.elsys.easybooker.repositories.ServiceRepository;

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

    public Location geLocationById(long locationId){
        return locationRepository.findById(locationId);
    }

    public List<Service> getServicesForLocation(long locationId) {
        return locationRepository.findById(locationId).getServices();

    }

    public void addServicesForLocation(long locationId, List<Long> serviceIds) {


    }
}
