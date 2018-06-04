package com.elsys.easybooker.services;

import com.elsys.easybooker.ResourceNotFoundException;
import com.elsys.easybooker.dtos.booking.BookingBriefDTO;
import com.elsys.easybooker.dtos.booking.BookingCreationDTO;
import com.elsys.easybooker.dtos.business.BusinessBriefDTO;
import com.elsys.easybooker.dtos.user.UserBriefDTO;
import com.elsys.easybooker.dtos.user.UserCreationDTO;
import com.elsys.easybooker.dtos.user.UserDTO;
import com.elsys.easybooker.dtos.user.UserUpdateDTO;
import com.elsys.easybooker.models.*;
import com.elsys.easybooker.repositories.*;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class  UserService {

    private final Path rootUserImagesLocation = Paths.get("src\\main\\resources\\static\\images\\users");
    private final UserRepository userRepository;
    private final BusinessRepository businessRepository;
    private final LocationRepository locationRepository;
    private final ServiceRepository serviceRepository;
    private final BookingRepository bookingRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ModelMapper modelMapper = new ModelMapper();

    public UserService(UserRepository userRepository,
                          BusinessRepository businessRepository,
                          LocationRepository locationRepository,
                          ServiceRepository serviceRepository,
                          BookingRepository bookingRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.businessRepository = businessRepository;
        this.locationRepository = locationRepository;
        this.serviceRepository = serviceRepository;
        this.bookingRepository = bookingRepository;
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

    public void addImageToUser(long userId, MultipartFile image) throws IOException {

        String imageName = "image";
        String imageExtension = ".png";

        new File(this.rootUserImagesLocation.toString() + "/" + userId ).mkdirs();
        Files.copy(image.getInputStream(), this.rootUserImagesLocation.resolve( userId + "/" + imageName + imageExtension));
    }

    public UserDTO getLoggedInUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return modelMapper.map(userRepository.findByUsername(auth.getName()), UserDTO.class);
    }

    public UserBriefDTO updateLoggedInUser(UserUpdateDTO userUpdateDTO){
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


    public BookingBriefDTO addBookingToUser(BookingCreationDTO bookingCreationDTO){

        Booking booking  = modelMapper.map(bookingCreationDTO, Booking.class);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User loggedInUser = userRepository.findByUsername(auth.getName());
        booking.setUser(loggedInUser);

        Business business = businessRepository.findById(bookingCreationDTO.getBusinessId());
        booking.setBusiness(business);

        Location location = locationRepository.findById(bookingCreationDTO.getLocationId());
        booking.setLocation(location);

        com.elsys.easybooker.models.Service service = serviceRepository.findById(bookingCreationDTO.getServiceId());
        booking.setService(service);

        booking = bookingRepository.save(booking);




//            Business business = businessRepository.findById(businessId);
//            service.setBusiness(business);
//            service = serviceRepository.save(service);
//            business.getServices().add(service);
//            businessRepository.save(business);


        return modelMapper.map(booking, BookingBriefDTO.class);

    }

    public List<BookingBriefDTO> getBookingsOfUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User loggedInUser = userRepository.findByUsername(auth.getName());
        List<BookingBriefDTO> bookingBriefDTOList = new ArrayList<>();
        for(Booking booking : bookingRepository.findByUser(loggedInUser) ){
            bookingBriefDTOList.add(modelMapper.map(booking,BookingBriefDTO.class));
        }

        return bookingBriefDTOList;
    }

}
