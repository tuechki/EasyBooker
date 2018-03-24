package com.elsys.easybooker.services;

import com.elsys.easybooker.ResourceNotFoundException;
import com.elsys.easybooker.dtos.business.BusinessBriefDTO;
import com.elsys.easybooker.dtos.user.UserBriefDTO;
import com.elsys.easybooker.dtos.user.UserCreationDTO;
import com.elsys.easybooker.dtos.user.UserDTO;
import com.elsys.easybooker.dtos.user.UserUpdateDTO;
import com.elsys.easybooker.models.User;
import com.elsys.easybooker.models.UserBusiness;
import com.elsys.easybooker.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public List<UserBriefDTO> getUsers() {
        List<UserBriefDTO> userBriefDTOList = new ArrayList<>();

        for (User user : userRepository.findAll()){
            userBriefDTOList.add(modelMapper.map(user, UserBriefDTO.class));
        }

        return userBriefDTOList;
    }

    public UserDTO getUserById(long userId) throws ResourceNotFoundException {
        return modelMapper.map(userRepository.findById(userId), UserDTO.class);
    }

    public UserDTO getUserByUsername(String username) throws ResourceNotFoundException {
        return modelMapper.map(userRepository.findByUsername(username), UserDTO.class);
    }


    public List<BusinessBriefDTO> getBusinessesForUser(String username) {
        User user = userRepository.findByUsername(username);
        List<BusinessBriefDTO> businessBriefDTOList = new ArrayList<>();

        for (UserBusiness userBusiness : user.getBusinessAssoc()){
            businessBriefDTOList.add(modelMapper.map(userBusiness.getBusiness(), BusinessBriefDTO.class));
        }
        return businessBriefDTOList;
    }

    public UserBriefDTO createUser(UserCreationDTO userCreationDTO) {
        User user = modelMapper.map(userCreationDTO, User.class);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);

        return modelMapper.map(user, UserBriefDTO.class);
    }

    public UserDTO getLoggedInUserInfo(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return modelMapper.map(userRepository.findByUsername(auth.getName()), UserDTO.class);
    }

    public UserBriefDTO updateLoggedInUserInfo(UserUpdateDTO userUpdateDTO){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(auth.getName());
        User updateUser = userRepository.save(modelMapper.map(userUpdateDTO, User.class));
        UserBriefDTO userBriefDTO = new UserBriefDTO();
        if(user.getUsername().equals(updateUser.getUsername())) {
            userBriefDTO = modelMapper.map(updateUser, UserBriefDTO.class);
        }

        return userBriefDTO;
    }

    public void deleteLoggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUsername(auth.getName());
    }

}
