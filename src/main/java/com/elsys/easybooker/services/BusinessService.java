package com.elsys.easybooker.services;

import com.elsys.easybooker.dtos.business.BusinessBriefDTO;
import com.elsys.easybooker.dtos.business.BusinessCreationDTO;
import com.elsys.easybooker.dtos.business.BusinessDTO;
import com.elsys.easybooker.dtos.business.BusinessUpdateDTO;
import com.elsys.easybooker.dtos.location.LocationBriefDTO;
import com.elsys.easybooker.dtos.location.LocationCreationDTO;
import com.elsys.easybooker.dtos.service.ServiceBriefDTO;
import com.elsys.easybooker.dtos.service.ServiceCreationDTO;
import com.elsys.easybooker.models.*;
import com.elsys.easybooker.repositories.*;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedClientException;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import static com.elsys.easybooker.security.SecurityConstants.ADMIN;

@org.springframework.stereotype.Service
public class BusinessService {

    private final Path rootBusinessImagesLocation = Paths.get("src\\main\\resources\\static\\images\\businesses");
    private final BusinessRepository businessRepository;
    private final UserRepository userRepository;
    private final ServiceRepository serviceRepository;
    private final LocationRepository locationRepository;
    private final DayScheduleRepository dayScheduleRepository;
    private final UsersBusinessesRepository usersBusinessesRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public BusinessService(BusinessRepository businessRepository,
                           UserRepository userRepository,
                           ServiceRepository serviceRepository,
                           LocationRepository locationRepository,
                           DayScheduleRepository dayScheduleRepository,
                           UsersBusinessesRepository usersBusinessesRepository){
        this.userRepository = userRepository;
        this.businessRepository = businessRepository;
        this.serviceRepository = serviceRepository;
        this.locationRepository = locationRepository;
        this.dayScheduleRepository = dayScheduleRepository;
        this.usersBusinessesRepository = usersBusinessesRepository;
    }

    public List<BusinessBriefDTO> getBusinesses() {
        List<BusinessBriefDTO> businessBriefDTOList = new ArrayList<>();
        for (Business business : businessRepository.findAll()){
            businessBriefDTOList.add(modelMapper.map(business, BusinessBriefDTO.class));
        }

        return businessBriefDTOList;
    }

    public List<BusinessBriefDTO> getBusinessesForLoggedUser() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(auth.getName());
        List<BusinessBriefDTO> businessBriefDTOList = new ArrayList<>();

        for (UserBusiness userBusiness : user.getBusinessAssoc()){
            businessBriefDTOList.add(modelMapper.map(userBusiness.getBusiness(), BusinessBriefDTO.class));
        }
        return businessBriefDTOList;
    }

    public BusinessDTO getBusinessById(long businessId) {
        return modelMapper.map(businessRepository.findById(businessId), BusinessDTO.class);
    }

    public BusinessBriefDTO createBusiness(BusinessCreationDTO businessCreationDTO) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User owner = userRepository.findByUsername(auth.getName());

        Business business = modelMapper.map(businessCreationDTO, Business.class);
        UserBusiness userBusiness = new UserBusiness();
        userBusiness.setBusiness(business);
        userBusiness.setUser(owner);
        userBusiness.setPermission(ADMIN);
        usersBusinessesRepository.save(userBusiness);

        business.getUserAssoc().add(userBusiness);
        owner.getBusinessAssoc().add(userBusiness);
        userRepository.save(owner);
        business = businessRepository.save(business);

        return modelMapper.map(business, BusinessBriefDTO.class);

    }

    public void addImageToBusiness(long businessId, MultipartFile image) throws IOException{

        String imageName = "image";
        String imageExtension = ".png";

        new File(this.rootBusinessImagesLocation.toString() + "/" + businessId ).mkdirs();
        Files.copy(image.getInputStream(), this.rootBusinessImagesLocation.resolve( businessId + "/" + imageName + imageExtension));
    }

    public BusinessBriefDTO updateBusiness(BusinessUpdateDTO businessUpdateDTO) throws UnauthorizedClientException{
        Business business = new Business();
        if(isUserBusinessAdmin(businessUpdateDTO.getId())){
           business = businessRepository.save(modelMapper.map(businessUpdateDTO, Business.class));
        }

        return modelMapper.map(business, BusinessBriefDTO.class);

         // TO DO implement equals and hashcode to entities //
    }


    public void deleteBusinessById(Long businessId) throws UnauthorizedClientException {
        if(isUserBusinessAdmin(businessId)) {
            businessRepository.delete(businessId);
        }
    }



    //----Services----//



    public List<ServiceBriefDTO> getBusinessServices(long businessId) {
         List<ServiceBriefDTO> serviceBriefDTOList = new ArrayList<>();
        for(Service service: serviceRepository.findByBusinessId(businessId)){

            serviceBriefDTOList.add(modelMapper.map(service, ServiceBriefDTO.class));
        }

        return serviceBriefDTOList;
    }


    public ServiceBriefDTO createBusinessService(long businessId, ServiceCreationDTO serviceCreationDTO)
                                                                        throws UnauthorizedClientException{

        Service service = modelMapper.map(serviceCreationDTO, Service.class);

        if(isUserBusinessAdmin(businessId)) {
            Business business = businessRepository.findById(businessId);
            service.setBusiness(business);
            service = serviceRepository.save(service);
            business.getServices().add(service);
            businessRepository.save(business);

        }

        return modelMapper.map(service, ServiceBriefDTO.class);
    }

    public void deleteBusinessServices(long businessId) throws UnauthorizedClientException{
        if(isUserBusinessAdmin(businessId)) {
            serviceRepository.deleteByBusinessId(businessId);
        }
    }


   //----Locations---//




    public List<LocationBriefDTO> getBusinessLocations(long businessId) {

        List<LocationBriefDTO> locationBriefDTOList = new ArrayList<>();

        for(Location location: locationRepository.findByBusinessId(businessId)){
              locationBriefDTOList.add(modelMapper.map(location, LocationBriefDTO.class));
        }

        return locationBriefDTOList;
    }


    public LocationBriefDTO createBusinessLocation(long businessId, LocationCreationDTO locationCreationDTO)
                                                                                        throws UnauthorizedClientException {
        Location location = modelMapper.map(locationCreationDTO, Location.class);

        if(isUserBusinessAdmin(businessId)) {
            Business business = businessRepository.findById(businessId);
                location.setBusiness(business);

//              location.setScheduleOfDays(locationDTO.getSchedulesOfDays());
//              location = setScheduleOfDaysForLocation(location);
//              location = setMinTimeBetweenServicesForLocation(location);
//              location = saveServicesToLocation(location);

                location = locationRepository.save(location);
                business.getLocations().add(location);
                businessRepository.save(business);

        }

        return modelMapper.map(location, LocationBriefDTO.class);
    }

//    public Location setScheduleOfDaysForLocation (Location location){
//        for(DaySchedule daySchedule : location.getScheduleOfDays()){
//            daySchedule.setLocation(location);
//            dayScheduleRepository.save(daySchedule);
//            location.getScheduleOfDays().add(daySchedule);
//        }
//
//        return location;
//    }
//
//    public Location setMinTimeBetweenServicesForLocation(Location location){
//        PGInterval minInterval = location.getServices().get(0).getTimeDuration();
//        for(Service service : location.getServices()){
//
//            if(minInterval.getDays() >= service.getTimeDuration().getDays()){
//                if(minInterval.getHours() >= service.getTimeDuration().getHours()){
//                    if(minInterval.getMinutes() >= service.getTimeDuration().getMinutes()){
//                        minInterval = service.getTimeDuration();
//                    }
//                }
//            }
//
//        }
//
//        location.setMinTimeBetweenServices(minInterval);
//        return location;
//    }

    public void deleteBusinessLocations(long businessId) throws UnauthorizedClientException{
        if(isUserBusinessAdmin(businessId)) {
            locationRepository.deleteByBusinessId(businessId);
        }
    }

    public boolean isUserBusinessAdmin(long businessId) throws UnauthorizedClientException{
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(auth.getName());

        for(UserBusiness userBusiness : user.getBusinessAssoc()){
            if(userBusiness.getBusiness().getId() == businessId
                    && userBusiness.getPermission() == ADMIN){
                return true;
            }
        }

        throw new UnauthorizedClientException("No permissions for requested operation.");
    }



}
