package com.elsys.easybooker.controllers;

import com.elsys.easybooker.models.Location;
import com.elsys.easybooker.models.LocationsServices;
import com.elsys.easybooker.models.Service;
import com.elsys.easybooker.repositories.LocationRepository;
import com.elsys.easybooker.repositories.LocationsServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;
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
        return locationRepository.save(location);
    }

    @PostMapping("/{id}/services")
    @ResponseStatus(HttpStatus.CREATED)
    public List<LocationsServices> createServicesToLocation(@Valid @RequestBody List<Service> services, @PathVariable long id) {
        for(Service service : services){
            LocationsServices locSer = new LocationsServices(id, service.getId());
            locationsServicesRepository.save(locSer);
        }

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