package com.elsys.easybooker.controllers;

import com.elsys.easybooker.models.Business;
import com.elsys.easybooker.models.Location;
import com.elsys.easybooker.models.Service;
import com.elsys.easybooker.repositories.LocationRepository;
import com.elsys.easybooker.repositories.ServiceRepository;
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

    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping
    public List<Location> getServices(){
        return locationRepository.findAll();
    }

    @GetMapping("/{locationId}")
    public Location getServiceById(@PathVariable long locationId){
        return locationRepository.findById(locationId);
    }

    @GetMapping("/{locationId}/services")
    public List<Service> getLocationsForService(@PathVariable long locationId) {
        return locationRepository.findById(locationId).getServices();

    }

    @GetMapping("/{locationId}/services/{serviceId}/freeHours")
    public long getLocationsForService(@PathVariable long locationId, @PathVariable long serviceId,
                                          @RequestBody LocalDate dateForBooking ) {
        Location location = locationRepository.findById(locationId);
        Service service = serviceRepository.findById(serviceId);
        Business business = location.getBusiness();

        return  DAYS.between(business.getCreatedAt(), dateForBooking);

    }


}