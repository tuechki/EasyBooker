package com.elsys.easybooker.controllers;

import com.elsys.easybooker.models.Service;
import com.elsys.easybooker.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/businesses/{businessId}/services")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;











    @GetMapping
    public Iterable findAll(@RequestParam Map<String, String> queryMap) {

        System.out.println(queryMap.toString());
        if(queryMap.containsKey("businessId")){
           return  serviceRepository.findByBusinessId(Long.parseLong(queryMap.get("businessId")));
        }
        return serviceRepository.findAll();
    }

    @GetMapping("/{id}")
    public Service findById(@PathVariable long id) {
        return serviceRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Service create(@Valid @RequestBody Service service) {
        return serviceRepository.save(service);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        try {
            serviceRepository.delete(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @PutMapping("/{id}")
    public Service update(@RequestBody Service service, @PathVariable Long id) {

        return serviceRepository.save(service);
    }

}