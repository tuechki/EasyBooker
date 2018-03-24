package com.elsys.easybooker.controllers;

import com.elsys.easybooker.dtos.business.BusinessBriefDTO;
import com.elsys.easybooker.dtos.location.LocationBriefDTO;
import com.elsys.easybooker.dtos.location.LocationDTO;
import com.elsys.easybooker.dtos.location.LocationUpdateDTO;
import com.elsys.easybooker.dtos.service.ServiceBriefDTO;
import com.elsys.easybooker.models.Service;
import com.elsys.easybooker.services.LocationService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<LocationBriefDTO> getLocations(){
        return locationService.getLocations();
    }

    @GetMapping("/{locationId}")
    public LocationDTO getLocationById(@PathVariable long locationId){
        return locationService.getLocationById(locationId);
    }

    @PutMapping
    public LocationBriefDTO updateLocationById(@RequestBody LocationUpdateDTO locationUpdateDTO){
        return locationService.updateLocationById(locationUpdateDTO);
    }

    @DeleteMapping("/{locationId}")
    public void deleteLocationById(@PathVariable long locationId){
         locationService.deleteLocationById(locationId);
    }

    @GetMapping("/{locationId}/business")
    public BusinessBriefDTO getBusinessForLocation(@PathVariable long locationId){
        return locationService.getBusinessForLocation(locationId);
    }


    @GetMapping("/{locationId}/services")
    public List<ServiceBriefDTO> getServicesForLocation(@PathVariable long locationId) {
        return locationService.getServicesForLocation(locationId);

    }

    @PostMapping("/{locationId}/services")
    public void addServicesToLocation(@PathVariable long locationId, @RequestBody List<Long> serviceIds) {
        locationService.addServicesToLocation(locationId, serviceIds);

    }

    @GetMapping("/{locationId}/services/{serviceId}/freeHours")
    public void getLocationsForService(@PathVariable long locationId, @PathVariable long serviceId,
                                          @RequestBody LocalDate dateForBooking ) {
//        Location location = locationRepository.findById(locationId);
//        Service service = serviceRepository.findById(serviceId);
//        Business business = location.getBusiness();
//
//        return  DAYS.between(business.getCreatedAt(), dateForBooking);

    }


}