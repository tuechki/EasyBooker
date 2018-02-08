package com.elsys.easybooker.controllers;

import com.elsys.easybooker.models.Business;
import com.elsys.easybooker.models.BusinessDao;
import com.elsys.easybooker.models.UsersBusinessesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/businesses")
public class BusinessController {

    @Autowired
    private BusinessDao businessDao;
    @Autowired
    private UsersBusinessesDao usersBusinessesDao;

    @GetMapping
    public Iterable findAll() {
        return businessDao.findAll();
    }

    @GetMapping("/{id}")
    public Business findById(@PathVariable long id) {
        return businessDao.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Business create(@Valid @RequestBody Business business ) {
        return businessDao.save(business);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        try {
            businessDao.delete(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @PutMapping("/{id}")
    public Business update(@RequestBody Business business, @PathVariable Long id) {
//        if (user.getId() != id) {
////            throw new UserIdMismatchException();
////        }
        return businessDao.save(business);
    }

}