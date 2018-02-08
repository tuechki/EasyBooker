package com.elsys.easybooker.controllers;

import com.elsys.easybooker.models.Location;
import com.elsys.easybooker.repositories.LocationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationDao locationDao;

    @GetMapping
    public Iterable findAll() {
        return locationDao.findAll();
    }

    @GetMapping("/{id}")
    public Location findById(@PathVariable long id) {
        return locationDao.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Location create(@Valid @RequestBody Location location) {
        return locationDao.save(location);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        try {
            locationDao.delete(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @PutMapping("/{id}")
    public Location update(@RequestBody Location location, @PathVariable Long id) {

        return locationDao.save(location);
    }

}