package com.elsys.easybooker.controllers;

import com.elsys.easybooker.dtos.BusinessDTO;
import com.elsys.easybooker.dtos.ServiceDTO;
import com.elsys.easybooker.models.Business;
import com.elsys.easybooker.models.Location;
import com.elsys.easybooker.models.Service;
import com.elsys.easybooker.repositories.LocationRepository;
import com.elsys.easybooker.repositories.ServiceRepository;
import com.elsys.easybooker.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import static java.time.temporal.ChronoUnit.DAYS;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public Iterable getLocations(){
        return locationService.getLocations();
    }

    @GetMapping("/{locationId}")
    public Location getLocationById(@PathVariable long locationId){
        return locationService.getLocationById(locationId);
    }

    @GetMapping("/{locationId}/business")
    public BusinessDTO getBusinessForLocation(@PathVariable long locationId){
        return locationService.getBusinessForLocation(locationId);
    }

    @GetMapping("/{locationId}/services")
    public List<Service> getServicesForLocation(@PathVariable long locationId) {
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