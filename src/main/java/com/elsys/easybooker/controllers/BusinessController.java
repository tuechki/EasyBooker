package com.elsys.easybooker.controllers;

import com.elsys.easybooker.models.Business;
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
    public Iterable findAll() {
        return businessRepository.findAll();
    }

    @GetMapping("/{id}")
    public Business findById(@PathVariable long id) {
        return businessRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Business create(@Valid @RequestBody Business business ) {


//        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
//        String decodedString = new String(decodedBytes);

        Business businessCreated = businessRepository.save(business);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        long businessId = businessCreated.getId();
        long userId = userRepository.findByUsername(auth.getName()).getId();

        usersBusinessesRepository.save(new UserBusiness(businessId, userId, ADMIN));

        return businessCreated;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        try {
            businessRepository.delete(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @PutMapping("/{id}")
    public Business update(@RequestBody Business business, @PathVariable Long id) {
//        if (user.getId() != id) {
////            throw new UserIdMismatchException();
////        }
        return businessRepository.save(business);
    }

}