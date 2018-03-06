package com.elsys.easybooker.controllers;

import com.elsys.easybooker.models.Location;
import com.elsys.easybooker.models.Service;
import com.elsys.easybooker.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping
    public List<Service> getServices(){
        return serviceRepository.findAll();
    }

    @GetMapping("/{serviceId}")
    public Service getServiceById(@PathVariable long serviceId){
        return serviceRepository.findById(serviceId);
    }

    @GetMapping("/{serviceId}/locations")
    public List<Location> getLocationsForService(@PathVariable long serviceId){
        //TO DO Implement //
        return null;
    }
    

}