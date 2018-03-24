package com.elsys.easybooker.controllers;

import com.elsys.easybooker.ResourceNotFoundException;
import com.elsys.easybooker.dtos.business.BusinessBriefDTO;
import com.elsys.easybooker.dtos.user.UserBriefDTO;
import com.elsys.easybooker.dtos.user.UserCreationDTO;
import com.elsys.easybooker.dtos.user.UserDTO;
import com.elsys.easybooker.dtos.user.UserUpdateDTO;
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
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserBriefDTO> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{userId}")
    public UserDTO getUserById(@PathVariable long userId) throws ResourceNotFoundException {
        return userService.getUserById(userId);
    }

    @GetMapping("/users/{username}")
    public UserDTO getUserByUsername(@PathVariable String username) throws ResourceNotFoundException {
        return userService.getUserByUsername(username);
    }

    @GetMapping("/users/{username}/businesses")
    public List<BusinessBriefDTO> getBusinessesForUser(@PathVariable String username) {
         return userService.getBusinessesForUser(username);
    }


    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserBriefDTO createUser(@Valid @RequestBody UserCreationDTO userCreationDTO) {
       return userService.createUser(userCreationDTO);
    }

    @GetMapping("/loggedInUserInfo")
    public UserDTO getLoggedUserInfo() throws ResourceNotFoundException {
        return userService.getLoggedInUserInfo();
    }

    @PutMapping("/loggedInUserInfo")
    public UserBriefDTO updateLoggedUserInfo(@RequestBody UserUpdateDTO userUpdateDTO) throws ResourceNotFoundException {
        return userService.updateLoggedInUserInfo(userUpdateDTO);
    }

    @DeleteMapping("/deleteLoggedInUser")
    public void updateLoggedUserInfo() throws ResourceNotFoundException {
        userService.deleteLoggedInUser();
    }

}