package com.elsys.easybooker.controllers;

import com.elsys.easybooker.models.Location;
import com.elsys.easybooker.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping
    public Iterable findAll() {
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