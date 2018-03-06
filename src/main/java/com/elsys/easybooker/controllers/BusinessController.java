package com.elsys.easybooker.controllers;

import com.elsys.easybooker.models.Business;
import com.elsys.easybooker.models.Location;
import com.elsys.easybooker.models.Service;
import com.elsys.easybooker.services.BusinessService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/businesses")
public class BusinessController {

    private final BusinessService businessService;

    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }


    @GetMapping
    public Iterable getBusinesses() {
        return businessService.getBusinesses();
    }

    @GetMapping("/{businessId}")
    public Business getBusinessById(@PathVariable long businessId) {
        return businessService.getBusinessById(businessId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBusiness(@Valid @RequestBody Business business ) {
        businessService.createBusiness(business);
    }

    @PutMapping
    public void updateBusinesses(@Valid @RequestBody Business business) {
        businessService.updateBusiness(business);
    }


    @DeleteMapping("/{businessId}")
    public void deleteBusinessById(@PathVariable Long businessId) {
        businessService.deleteBusinessById(businessId);
    }



    @GetMapping("/{businessId}/services")
    public List<Service> getBusinessServices(@PathVariable long businessId) {
       return  businessService.getBusinessServices(businessId);
    }


    @PostMapping("/{businessId}/services")
    public void createBusinessServices(@PathVariable long businessId, @RequestBody List<Service> services) {
        businessService.createOrUpdateBusinessServices(businessId, services);
    }

    @PutMapping("/{businessId}/services")
    public void updateBusinessServices(@PathVariable long businessId, @RequestBody List<Service> services) {
        businessService.createOrUpdateBusinessServices(businessId, services);
    }

    @DeleteMapping("/{businessId}/services")
    public void deleteBusinessServices(@PathVariable long businessId) {
        businessService.deleteBusinessServices(businessId);
    }

    @DeleteMapping("/{businessId}/services/{serviceId}")
    public void deleteBusinessServices(@PathVariable long businessId, @PathVariable long serviceId) {
        businessService.deleteBusinessServiceById(businessId,serviceId);
    }


    @GetMapping("/{businessId}/locations")
    public List<Location> getBusinessLocations(@PathVariable long businessId) {
        return businessService.getBusinessLocations(businessId);
    }


    @PostMapping("/{businessId}/locations")
    public void createBusinessLocations(@PathVariable long businessId, @RequestBody List<Location> locations) {
        businessService.createOrUpdateBusinessLocations(businessId, locations);
    }

    @PutMapping("/{businessId}/locations")
    public void updateBusinessLocations(@PathVariable long businessId,  @RequestBody List<Location> locations) {
        businessService.createOrUpdateBusinessLocations(businessId, locations);
    }


    @DeleteMapping("/{businessId}/locations")
    public void deleteBusinessLocations(@PathVariable long businessId) {
        businessService.deleteBusinessLocations(businessId);
    }

    @DeleteMapping("/{businessId}/locations/{locationId}")
    public void deleteBusinessLocationById(@PathVariable long businessId, @PathVariable long locationId) {
        businessService.deleteBusinessLocationById(businessId, locationId);
    }

}