package com.elsys.easybooker.services;

import com.elsys.easybooker.dtos.BusinessDTO;
import com.elsys.easybooker.dtos.LocationDTO;
import com.elsys.easybooker.dtos.ServiceDTO;
import com.elsys.easybooker.models.*;
import com.elsys.easybooker.repositories.*;
import javassist.bytecode.ByteArray;
import org.apache.commons.io.IOUtils;
import org.modelmapper.ModelMapper;
import org.postgresql.util.PGInterval;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedClientException;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLConnection;
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

    public Iterable getBusinesses() {
        return businessRepository.findAll();
    }

    public Business getBusinessById( long businessId) {
        return businessRepository.findById(businessId);
    }

    public Business createBusiness(BusinessDTO businessDTO ) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User owner = userRepository.findByUsername(auth.getName());

        Business business = new Business();
        business.setName(businessDTO.getName());
        business.setSummary(businessDTO.getSummary());
        business.setEmail(businessDTO.getEmail());

        UserBusiness userBusiness = new UserBusiness();

        userBusiness.setBusiness(business);
        userBusiness.setUser(owner);
        userBusiness.setPermission(ADMIN);
        usersBusinessesRepository.save(userBusiness);

        business.getUserAssoc().add(userBusiness);
        owner.getBusinessAssoc().add(userBusiness);
        userRepository.save(owner);
        return businessRepository.save(business);

    }

    public void addImageToBusiness(long businessId, MultipartFile image) throws IOException{

        String imageName = "image";
        String imageExtension = ".png";

        new File(this.rootBusinessImagesLocation.toString() + "/" + businessId ).mkdirs();
        Files.copy(image.getInputStream(), this.rootBusinessImagesLocation.resolve( businessId + "/" + imageName + imageExtension));
    }

    public void updateBusiness( Business business) throws UnauthorizedClientException{
        if(isUserBusinessAdmin(business.getId())){
            businessRepository.save(business);
        }

         // TO DO implement equals and hashcode to entities //
    }


    public void deleteBusinessById(Long businessId) throws UnauthorizedClientException {
        if(isUserBusinessAdmin(businessId)) {
            businessRepository.delete(businessId);
        }
    }



    public Iterable getBusinessServices(long businessId) {
         List<ServiceDTO> servicesDTO = new ArrayList<>();
        for(Service service: serviceRepository.findByBusinessId(businessId)){

            ServiceDTO serviceDTO = new ServiceDTO();

            serviceDTO.setId(service.getId());
            serviceDTO.setName(service.getName());
            serviceDTO.setSummary(service.getSummary());
            serviceDTO.setTimeDuration(service.getTimeDuration());
            serviceDTO.setPrice(service.getPrice());
            serviceDTO.setBusinessId(service.getBusiness().getId());

            servicesDTO.add(serviceDTO);
        }

        return servicesDTO;
    }


    public void createOrUpdateBusinessService(long businessId, ServiceDTO serviceDTO) throws UnauthorizedClientException{

        Service service = modelMapper.map(serviceDTO, Service.class);

        if(isUserBusinessAdmin(businessId)) {
            Business business = businessRepository.findById(businessId);
            service.setBusiness(business);
            service = serviceRepository.save(service);
            business.getServices().add(service);
            businessRepository.save(business);

        }
    }

    public void deleteBusinessServices(long businessId) throws UnauthorizedClientException{
        if(isUserBusinessAdmin(businessId)) {
            serviceRepository.deleteByBusinessId(businessId);
        }
    }


    public void deleteBusinessServiceById(long businessId, long serviceId) throws UnauthorizedClientException {
        if(isUserBusinessAdmin(businessId)) {
            serviceRepository.delete(serviceId);
        }
    }



    public Iterable getBusinessLocations(long businessId) {

        List<LocationDTO> locationsDTO = new ArrayList<>();
        for(Location location: locationRepository.findByBusinessId(businessId)){

              LocationDTO locationDTO = modelMapper.map(location, LocationDTO.class);
              locationsDTO.add(locationDTO);
        }

        return locationsDTO;
    }


    public void createOrUpdateBusinessLocations(long businessId, LocationDTO locationDTO) throws UnauthorizedClientException {
        if(isUserBusinessAdmin(businessId)) {
            Business business = businessRepository.findById(businessId);

                Location location = new Location();
                location.setAddress(locationDTO.getAddress());
                location.setSummary(locationDTO.getSummary());
                location.setEmail(locationDTO.getEmail());
                location.setNumber(locationDTO.getNumber());
                location.setBusiness(business);


//              location.setScheduleOfDays(locationDTO.getSchedulesOfDays());

//              location = setScheduleOfDaysForLocation(location);
//              location = setMinTimeBetweenServicesForLocation(location);
//              location = saveServicesToLocation(location);

                locationRepository.save(location);

                business.getLocations().add(location);
                businessRepository.save(business);

        }
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

    public void deleteBusinessLocationById(long businessId, long locationId) throws UnauthorizedClientException {
        if(isUserBusinessAdmin(businessId)) {
            locationRepository.delete(locationId);
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
