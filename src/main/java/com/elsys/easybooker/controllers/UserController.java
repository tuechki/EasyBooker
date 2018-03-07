package com.elsys.easybooker.controllers;

import com.elsys.easybooker.ResourceNotFoundException;
import com.elsys.easybooker.models.Business;
import com.elsys.easybooker.models.User;
import com.elsys.easybooker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserRepository userRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping
    public Iterable getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) throws ResourceNotFoundException {
        return userRepository.findById(id);
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) throws ResourceNotFoundException {
        return userRepository.findByUsername(username);
    }

    @GetMapping("/{id}/businesses")
    public Iterable getBusinessesForLoggedInUser(@PathVariable long id) {
        // TO DO userService.getBusinessesForLoggedInUser(); //
        return userRepository.findAll();
    }

    @GetMapping("/{username}/businesses")
    public Iterable getBusinessesForLoggedInUser(@PathVariable String username) {
        // TO DO userService.getBusinessesForLoggedInUser(); //
        return userRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @PutMapping
    public void updateUsers(@Valid @RequestBody List<User> users) {
        // TO DO implement userService.updateUsers()//
    }

    @PutMapping("/{id}")
    public void updateUserById(@Valid @RequestBody User user, @PathVariable long id) {
        // TO DO implement  userService.updateUserById(id);//
    }

    @PutMapping("/{username}")
    public void updateUserById(@Valid @RequestBody User user, @PathVariable String username) {
        // TO DO implement  userService.updateUserByUsername(username);//
    }

    @DeleteMapping
    public void deleteUsers() {
        //TO DO implement userService.deleteUsers(id);//
        //userRepository.deleteAll();//
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {

        //TO DO implement userService.deleteUserById(id);//
        try {
            userRepository.delete(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @DeleteMapping("/{username}")
    public void deleteUserByUsername(@PathVariable String username) {

        //TO DO implement userService.deleteUserByUsername(username);//

    }

}