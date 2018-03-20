package com.elsys.easybooker.services;

import com.elsys.easybooker.models.Business;
import com.elsys.easybooker.models.Location;
import com.elsys.easybooker.models.Service;
import com.elsys.easybooker.repositories.LocationRepository;
import com.elsys.easybooker.repositories.ServiceRepository;

@org.springframework.stereotype.Service
public class ServiceService {

    private final ServiceRepository serviceRepository;
    private final LocationRepository locationRepository;

    public ServiceService(
            ServiceRepository serviceRepository,
            LocationRepository locationRepository){

        this.serviceRepository = serviceRepository;
        this.locationRepository = locationRepository;
    }


    public Iterable getServices(){
        return serviceRepository.findAll();
    }

    public Service getServiceById(long serviceId){
        return serviceRepository.findById(serviceId);
    }

    public Iterable getLocationsForService( long serviceId){
        return serviceRepository.findById(serviceId).getLocations();
    }

    public Business getBusinessForService(long serviceId){
        Service service = serviceRepository.findById(serviceId);
        return service.getBusiness();
    }
}
