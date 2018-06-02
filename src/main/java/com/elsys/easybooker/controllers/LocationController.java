package com.elsys.easybooker.controllers;

import com.elsys.easybooker.dtos.booking.BookingBriefDTO;
import com.elsys.easybooker.dtos.business.BusinessBriefDTO;
import com.elsys.easybooker.dtos.location.LocationBriefDTO;
import com.elsys.easybooker.dtos.location.LocationDTO;
import com.elsys.easybooker.dtos.location.LocationUpdateDTO;
import com.elsys.easybooker.dtos.service.ServiceBriefDTO;
import com.elsys.easybooker.models.Booking;
import com.elsys.easybooker.models.DaySchedule;
import com.elsys.easybooker.models.Service;
import com.elsys.easybooker.repositories.BookingRepository;
import com.elsys.easybooker.services.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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

    @GetMapping("/{locationId}/schedule")
    public List<DaySchedule> getDayScheduleForLocation(@PathVariable long locationId){
        return locationService.getDayScheduleForLocation(locationId);
    }

    @PutMapping
    public LocationBriefDTO updateLocationById(@RequestBody LocationUpdateDTO locationUpdateDTO){
        return locationService.updateLocationById(locationUpdateDTO);
    }

    @PostMapping("/{locationId}/images")
    @ResponseStatus(HttpStatus.CREATED)
    public void addImageToLocation(@Valid @PathVariable long locationId, @RequestParam("image") MultipartFile image)
            throws IOException {
        locationService.addImageToLocation(locationId, image);
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

    @GetMapping("/{locationId}/services/{serviceId}/{year}/{month}/{day}")
    public List<LocalTime> getFreeHours(@PathVariable long locationId, @PathVariable long serviceId,
                                        @PathVariable int year, @PathVariable int month, @PathVariable int day) {


        return locationService.getFreeHours(locationId, serviceId, year, month, day);
    }


}