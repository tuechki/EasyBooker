package com.elsys.easybooker.controllers;

import com.elsys.easybooker.ResourceNotFoundException;
import com.elsys.easybooker.models.Business;
import com.elsys.easybooker.models.User;
import com.elsys.easybooker.repositories.UserRepository;
import com.elsys.easybooker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Iterable getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable long userId) throws ResourceNotFoundException {
        return userService.getUserById(userId);
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) throws ResourceNotFoundException {
        return userService.getUserByUsername(username);
    }

    @GetMapping("/{username}/businesses")
    public Iterable getBusinessesForLoggedInUser(@PathVariable String username) {
         return userService.getBusinessesForUser(username);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody User user) {
        userService.createUser(user);
    }

    @PutMapping
    public void updateUsers(@Valid @RequestBody List<User> users) {
        userService.updateUsers(users);
    }

    @DeleteMapping
    public void deleteUsers() {
       userService.deleteUsers();
    }

    @DeleteMapping("/{username}")
    public void deleteUserByUsername(@PathVariable String username) {
        userService.deleteUserByUsername(username);
    }

}