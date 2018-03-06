package com.elsys.easybooker.controllers;

import com.elsys.easybooker.models.Business;
import com.elsys.easybooker.models.Location;
import com.elsys.easybooker.models.Service;
import com.elsys.easybooker.models.UserBusiness;
import com.elsys.easybooker.repositories.BusinessRepository;
import com.elsys.easybooker.repositories.UserRepository;
import com.elsys.easybooker.repositories.UsersBusinessesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.elsys.easybooker.security.SecurityConstants.ADMIN;

@RestController
@RequestMapping("/businesses")
public class BusinessController {

    @Autowired
    private BusinessRepository businessRepository;
    @Autowired
    private UsersBusinessesRepository usersBusinessesRepository;
    @Autowired
    private UserRepository userRepository;


    @GetMapping
    public Iterable getBusinesses() {
        return businessRepository.findAll();
    }

    @GetMapping("/{id}")
    public Business getBusinessById(@PathVariable long id) {
        return businessRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Business createBusiness(@Valid @RequestBody Business business ) {

        Business businessCreated = businessRepository.save(business);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        usersBusinessesRepository.save(new UserBusiness(userRepository.findByUsername(auth.getName()), businessCreated, ADMIN));

        return businessCreated;
    }

    @PutMapping
    public void updateBusinesses(@Valid @RequestBody List<Business> businesses) {
        // TO DO implement businessService.updateBusinesses(businesses)//
    }

    @PutMapping("/{id}")
    public void updateBusinessById(@Valid @RequestBody Business business, @PathVariable long id) {
        // TO DO implement  businessService.updateBusinessById(id, business);//
    }

    @DeleteMapping
    public void deleteBusinesses() {
        //TO DO implement businessService.deleteBusinesses(id);//
        //businessRepository.deleteAll();//
    }

    @DeleteMapping("/{id}")
    public void deleteBusinessById(@PathVariable Long id) {
        try {
            businessRepository.delete(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }



    @GetMapping("/{businessId}/services")
    public List<Service> getBusinessServices(@PathVariable long businessId) {
        // TO DO implement  //
        return null;
    }

    @GetMapping("/{businessId}/services/{serviceId}")
    public List<Service> getBusinessServiceById(@PathVariable long businessId, @PathVariable long serviceId) {
        // TO DO implement  //
        return null;
    }

    @PostMapping("/{businessId}/services")
    public List<Service> createBusinessService(@PathVariable long businessId, @RequestBody Service service) {
        // TO DO implement  //
        return null;
    }

    @PutMapping("/{businessId}/services")
    public List<Service> updateBusinessServices(@PathVariable long businessId) {
        // TO DO implement //
        return null;
    }

    @PutMapping("/{businessId}/services/{serviceId}")
    public List<Service> updateBusinessServiceById(@PathVariable long businessId, @PathVariable long serviceId) {
        // TO DO implement //
        return null;
    }


    @DeleteMapping("/{businessId}/services")
    public List<Service> deleteBusinessServices(@PathVariable long businessId) {
        // TO DO implement //
        return null;
    }

    @DeleteMapping("/{businessId}/services/{serviceId}")
    public List<Service> deleteBusinessServiceById(@PathVariable long businessId, @PathVariable long serviceId) {
        // TO DO implement //
        return null;
    }





    @GetMapping("/{businessId}/locations")
    public List<Service> getBusinessLocations(@PathVariable long businessId) {
        // TO DO implement  //
        return null;
    }

    @GetMapping("/{businessId}/locations/{locationId}")
    public List<Service> getBusinessLocationById(@PathVariable long businessId, @PathVariable long locationId) {
        // TO DO implement  //
        return null;
    }

    @PostMapping("/{businessId}/locations")
    public List<Service> createBusinessLocation(@PathVariable long businessId, @RequestBody Location location) {
        // TO DO implement  //
        return null;
    }

    @PutMapping("/{businessId}/locations")
    public List<Service> updateBusinessLocations(@PathVariable long businessId) {
        // TO DO implement //
        return null;
    }

    @PutMapping("/{businessId}/locations/{locationId}")
    public List<Service> updateBusinessLocationById(@PathVariable long businessId, @PathVariable long locationId) {
        // TO DO implement //
        return null;
    }


    @DeleteMapping("/{businessId}/locations")
    public List<Service> deleteBusinessLocations(@PathVariable long businessId) {
        // TO DO implement //
        return null;
    }

    @DeleteMapping("/{businessId}/locations/{locationId}")
    public List<Service> deleteBusinessLocationById(@PathVariable long businessId, @PathVariable long locationId) {
        // TO DO implement //
        return null;
    }

}