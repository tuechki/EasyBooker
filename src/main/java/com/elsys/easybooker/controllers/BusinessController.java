package com.elsys.easybooker.controllers;

import com.elsys.easybooker.dtos.business.BusinessCreationDTO;
import com.elsys.easybooker.dtos.business.BusinessDTO;
import com.elsys.easybooker.dtos.business.BusinessBriefDTO;
import com.elsys.easybooker.dtos.business.BusinessUpdateDTO;
import com.elsys.easybooker.dtos.location.LocationBriefDTO;
import com.elsys.easybooker.dtos.location.LocationCreationDTO;
import com.elsys.easybooker.dtos.service.ServiceBriefDTO;
import com.elsys.easybooker.dtos.service.ServiceCreationDTO;
import com.elsys.easybooker.services.BusinessService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/businesses")
public class BusinessController {

    private final BusinessService businessService;

    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }


    @GetMapping
    public List<BusinessBriefDTO> getBusinesses() {
        return businessService.getBusinesses();
    }

    @GetMapping("/{businessId}")
    public BusinessDTO getBusinessById(@PathVariable long businessId) {
        return businessService.getBusinessById(businessId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BusinessBriefDTO createBusiness(@Valid @RequestBody BusinessCreationDTO businessCreationDTO ) {
        return  businessService.createBusiness(businessCreationDTO);
    }

    @PostMapping("/{businessId}/images")
    @ResponseStatus(HttpStatus.CREATED)
    public void addImageToBusiness(@Valid @PathVariable long businessId, @RequestParam("image") MultipartFile image)
            throws IOException {
        businessService.addImageToBusiness(businessId, image);
    }

    @PutMapping
    public BusinessBriefDTO updateBusinesses(@Valid @RequestBody BusinessUpdateDTO businessUpdateDTO) {
       return  businessService.updateBusiness(businessUpdateDTO);
    }


    @DeleteMapping("/{businessId}")
    public void deleteBusinessById(@PathVariable Long businessId) {
        businessService.deleteBusinessById(businessId);
    }


    @GetMapping("/{businessId}/services")
    public List<ServiceBriefDTO> getBusinessServices(@PathVariable long businessId) {
       return  businessService.getBusinessServices(businessId);
    }


    @PostMapping("/{businessId}/services")
    public void createBusinessService(@PathVariable long businessId, @RequestBody ServiceCreationDTO serviceCreationDTO) {
        businessService.createBusinessService(businessId, serviceCreationDTO);
    }


    @DeleteMapping("/{businessId}/services")
    public void deleteBusinessServices(@PathVariable long businessId) {
        businessService.deleteBusinessServices(businessId);
    }


    @GetMapping("/{businessId}/locations")
    public List<LocationBriefDTO> getBusinessLocations(@PathVariable long businessId) {
        return businessService.getBusinessLocations(businessId);
    }


    @PostMapping("/{businessId}/locations")
    public LocationBriefDTO createBusinessLocation(@PathVariable long businessId,
                                                   @RequestBody LocationCreationDTO locationCreationDTO) {
       return businessService.createBusinessLocation(businessId, locationCreationDTO);
    }


    @DeleteMapping("/{businessId}/locations")
    public void deleteBusinessLocations(@PathVariable long businessId) {
        businessService.deleteBusinessLocations(businessId);
    }

}