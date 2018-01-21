package com.elsys.easybooker.controllers;

import com.elsys.easybooker.models.User;
import com.elsys.easybooker.models.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping
    public Iterable findAll() {
        return userDao.findAll();
    }

    @GetMapping("/{username}")
    public User findByUsername(@PathVariable String username) {
        return userDao.findByUsername(username);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@Valid @RequestBody User user) {
        return userDao.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        try {
            userDao.delete(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id) {
//        if (user.getId() != id) {
////            throw new UserIdMismatchException();
////        }
        return userDao.save(user);
    }

}