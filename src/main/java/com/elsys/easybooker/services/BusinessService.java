package com.elsys.easybooker.services;

import com.elsys.easybooker.dtos.BusinessDTO;
import com.elsys.easybooker.models.*;
import com.elsys.easybooker.repositories.*;
import org.postgresql.util.PGInterval;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedClientException;
import java.util.List;
import static com.elsys.easybooker.security.SecurityConstants.ADMIN;

@org.springframework.stereotype.Service
public class BusinessService {

    private final BusinessRepository businessRepository;
    private final UserRepository userRepository;
    private final ServiceRepository serviceRepository;
    private final LocationRepository locationRepository;
    private final DayScheduleRepository dayScheduleRepository;
    private final UsersBusinessesRepository usersBusinessesRepository;

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

    public void createBusiness(BusinessDTO businessDTO ) {

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
        businessRepository.save(business);
        userRepository.save(owner);
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



    public List<Service> getBusinessServices(long businessId) {
        return serviceRepository.findByBusinessId(businessId);
    }


    public void createOrUpdateBusinessService(long businessId, Service service) throws UnauthorizedClientException{
        if(isUserBusinessAdmin(businessId)) {
            Business business = businessRepository.findById(businessId);
            service.setBusiness(business);
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



    public List<Location> getBusinessLocations(long businessId) {
       return  locationRepository.findAll();
    }


    public void createOrUpdateBusinessLocations(long businessId, List<Location> locations) throws UnauthorizedClientException {
        if(isUserBusinessAdmin(businessId)) {
            Business business = businessRepository.findById(businessId);
            for (Location location : locations) {
                location.setBusiness(business);

                location = setScheduleOfDaysForLocation(location);
                location = setMinTimeBetweenServicesForLocation(location);
                location = saveServicesToLocation(location);

                locationRepository.save(location);
            }
            business.getLocations().addAll(locations);
            businessRepository.save(business);

        }
    }

    public Location setScheduleOfDaysForLocation (Location location){
        for(DaySchedule daySchedule : location.getScheduleOfDays()){
            daySchedule.setLocation(location);
            dayScheduleRepository.save(daySchedule);
            location.getScheduleOfDays().add(daySchedule);
        }

        return location;
    }

    public Location setMinTimeBetweenServicesForLocation(Location location){
        PGInterval minInterval = location.getServices().get(0).getTimeDuration();
        for(Service service : location.getServices()){

            if(minInterval.getDays() >= service.getTimeDuration().getDays()){
                if(minInterval.getHours() >= service.getTimeDuration().getHours()){
                    if(minInterval.getMinutes() >= service.getTimeDuration().getMinutes()){
                        minInterval = service.getTimeDuration();
                    }
                }
            }

        }

        location.setMinTimeBetweenServices(minInterval);
        return location;
    }

    public Location saveServicesToLocation(Location location){
        for(Service service : location.getServices()){
            service.getLocations().add(location);
            serviceRepository.save(service);
            location.getServices().add(service);
        }

        return  location;
    }

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
