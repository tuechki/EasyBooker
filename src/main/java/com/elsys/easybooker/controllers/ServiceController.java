package com.elsys.easybooker.controllers;
import com.elsys.easybooker.models.Business;
import com.elsys.easybooker.models.Service;
import com.elsys.easybooker.services.ServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/services")
public class ServiceController {

    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping
    public Iterable getServices(){
        return serviceService.getServices();
    }

    @GetMapping("/{serviceId}")
    public Service getServiceById(@PathVariable long serviceId){
        return serviceService.getServiceById(serviceId);
    }

    @GetMapping("/{serviceId}/locations")
    public Iterable getLocationsForService(@PathVariable long serviceId){
        return serviceService.getLocationsForService(serviceId);
    }

    @GetMapping("/{serviceId}/business")
    public Business getBusinessForService(@PathVariable long serviceId){
        return serviceService.getBusinessForService(serviceId);
    }


}