package com.elsys.easybooker.controllers;
import com.elsys.easybooker.dtos.booking.BookingBriefDTO;
import com.elsys.easybooker.dtos.business.BusinessBriefDTO;
import com.elsys.easybooker.dtos.location.LocationBriefDTO;
import com.elsys.easybooker.dtos.service.ServiceBriefDTO;
import com.elsys.easybooker.dtos.service.ServiceDTO;
import com.elsys.easybooker.dtos.service.ServiceUpdateDTO;
import com.elsys.easybooker.models.Business;
import com.elsys.easybooker.models.Service;
import com.elsys.easybooker.services.ServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
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
    public ServiceDTO getServiceById(@PathVariable long serviceId){
        return serviceService.getServiceById(serviceId);
    }

    @PutMapping
    public ServiceBriefDTO updateServiceById(@RequestBody ServiceUpdateDTO serviceUpdateDTO){
        return serviceService.updateServiceById(serviceUpdateDTO);
    }

    @PostMapping("/{serviceId}/images")
    @ResponseStatus(HttpStatus.CREATED)
    public void addImageToService(@Valid @PathVariable long serviceId, @RequestParam("image") MultipartFile image)
            throws IOException {
        serviceService.addImageToService(serviceId, image);
    }

    @DeleteMapping("/{serviceId}")
    public void deleteServiceById(@PathVariable long serviceId){
        serviceService.deleteServiceById(serviceId);
    }

    @GetMapping("/{serviceId}/locations")
    public List<LocationBriefDTO> getLocationsForService(@PathVariable long serviceId){
        return serviceService.getLocationsForService(serviceId);
    }

    @GetMapping("/{serviceId}/business")
    public BusinessBriefDTO getBusinessForService(@PathVariable long serviceId){
        return serviceService.getBusinessForService(serviceId);
    }

    @GetMapping("/{serviceId}/bookings")
    public List<BookingBriefDTO> getBusinessBookings(@PathVariable long serviceId) {
        return serviceService.getServiceBookings(serviceId);
    }

}