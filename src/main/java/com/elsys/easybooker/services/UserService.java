package com.elsys.easybooker.services;

import com.elsys.easybooker.ResourceNotFoundException;
import com.elsys.easybooker.dtos.BusinessDTO;
import com.elsys.easybooker.models.Business;
import com.elsys.easybooker.models.User;
import com.elsys.easybooker.models.UserBusiness;
import com.elsys.easybooker.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class    UserService {

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


    public Iterable getBusinessesForUser(String username) {
        User loggedInUser = userRepository.findByUsername(username);

        System.out.println("------------------------" + loggedInUser.getUsername());

        List<BusinessDTO> businessesDTO = new ArrayList<>();
        for (UserBusiness userBusiness : loggedInUser.getBusinessAssoc()){
            BusinessDTO businessDTO = new BusinessDTO();
            businessDTO.setId(userBusiness.getBusiness().getId());
            businessDTO.setName(userBusiness.getBusiness().getName());
            businessDTO.setSummary(userBusiness.getBusiness().getSummary());
            businessDTO.setEmail(userBusiness.getBusiness().getEmail());

            businessesDTO.add(businessDTO);
            System.out.println("---///---///---" + userBusiness.getBusiness().getId());
        }

        return businessesDTO;
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

    public void deleteUserByUsername(String username) {

        //TO DO if authorized to delete the user //
        userRepository.deleteByUsername(username);

    }
}
