package com.elsys.easybooker.services;

import com.elsys.easybooker.ResourceNotFoundException;
import com.elsys.easybooker.models.Business;
import com.elsys.easybooker.models.User;
import com.elsys.easybooker.models.UserBusiness;
import com.elsys.easybooker.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Iterable getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(long userId) throws ResourceNotFoundException {
        return userRepository.findById(userId);
    }

    public User getUserByUsername(String username) throws ResourceNotFoundException {
        return userRepository.findByUsername(username);
    }

    public Iterable getBusinessesForLoggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User loggedInUser = userRepository.findByUsername(auth.getName());

        List<Business> businesses = null;
        for (UserBusiness userBusiness : loggedInUser.getBusinessAssoc()){
            businesses.add(userBusiness.getBusiness());
        }

        return businesses;
    }

    public void createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void updateUsers(List<User> users) {

        //TO DO if authorized to delete the user //
        userRepository.save(users);
    }

    public void deleteUsers() {
        userRepository.deleteAll();
    }

    public void deleteUser() {

        //TO DO if authorized to delete the user //
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUsername(auth.getName());

    }
}
