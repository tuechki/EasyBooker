package com.elsys.easybooker.controllers;

import com.elsys.easybooker.models.Location;
import com.elsys.easybooker.models.LocationsServices;
import com.elsys.easybooker.models.Service;
import com.elsys.easybooker.repositories.LocationRepository;
import com.elsys.easybooker.repositories.LocationsServicesRepository;
import com.elsys.easybooker.repositories.ServiceRepository;
import org.postgresql.util.PGInterval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private LocationsServicesRepository locationsServicesRepository;

    @GetMapping
    public Iterable findAll(@RequestParam Map<String, String> queryMap) {
        System.out.println(queryMap.toString());
        if(queryMap.containsKey("businessId")){
            return  locationRepository.findByBusinessId(Long.parseLong(queryMap.get("businessId")));
        }
        return locationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Location findById(@PathVariable long id) {
        return locationRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Location create(@Valid @RequestBody Location location) {
        Location savedLocation = locationRepository.save(location);
        List<Service> belongingServices = new ArrayList<>();

        for(LocationsServices locSer : locationsServicesRepository.findByLocationId(savedLocation.getId())){
            belongingServices.add(serviceRepository.findById(locSer.getServiceId()));
        }

        for(Service serv : belongingServices){
            System.out.println(serv.getName() + "    " + serv.getTimeDuration());
        }

        return savedLocation;
    }

    @PostMapping("/{id}/services")
    @ResponseStatus(HttpStatus.CREATED)
    public List<LocationsServices> createServicesToLocation(@Valid @RequestBody List<Service> services, @PathVariable long id) {

        PGInterval minInterval = services.get(0).getTimeDuration();

        for(Service service : services){

            if(minInterval.getDays() >= service.getTimeDuration().getDays()){
                if(minInterval.getHours() >= service.getTimeDuration().getHours()){
                    if(minInterval.getMinutes() >= service.getTimeDuration().getMinutes()){
                        minInterval = service.getTimeDuration();
                    }
                }
            }

            LocationsServices locSer = new LocationsServices(id, service.getId());
            locationsServicesRepository.save(locSer);
        }

        locationRepository.findById(id).setMinTimeBetweenServices(minInterval);
        return locationsServicesRepository.findByLocationId(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        try {
            locationRepository.delete(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @PutMapping("/{id}")
    public Location update(@RequestBody Location location, @PathVariable Long id) {

        return locationRepository.save(location);
    }

}