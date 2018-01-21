package com.elsys.easybooker.controllers;

import com.elsys.easybooker.models.Service;
import com.elsys.easybooker.models.ServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServiceDao serviceDao;

    @GetMapping
    public Iterable findAll() {
        return serviceDao.findAll();
    }

    @GetMapping("/{id}")
    public Service findById(@PathVariable long id) {
        return serviceDao.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Service create(@Valid @RequestBody Service service) {
        return serviceDao.save(service);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        try {
            serviceDao.delete(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @PutMapping("/{id}")
    public Service update(@RequestBody Service service, @PathVariable Long id) {

        return serviceDao.save(service);
    }

}