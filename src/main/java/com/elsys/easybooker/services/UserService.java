package com.elsys.easybooker.services;

import com.elsys.easybooker.ResourceNotFoundException;
import com.elsys.easybooker.dtos.business.BusinessBriefDTO;
import com.elsys.easybooker.models.User;
import com.elsys.easybooker.models.UserBusiness;
import com.elsys.easybooker.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class  UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ModelMapper modelMapper = new ModelMapper();

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

        List<BusinessBriefDTO> businessBriefDTOList = new ArrayList<>();
        for (UserBusiness userBusiness : loggedInUser.getBusinessAssoc()){


            businessBriefDTOList.add(modelMapper.map(userBusiness.getBusiness(), BusinessBriefDTO.class));
            System.out.println("---///---///---" + userBusiness.getBusiness().getId());
        }

        return businessBriefDTOList;
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
