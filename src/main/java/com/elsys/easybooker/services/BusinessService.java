package com.elsys.easybooker.services;

import com.elsys.easybooker.models.*;
import com.elsys.easybooker.repositories.BusinessRepository;
import com.elsys.easybooker.repositories.LocationRepository;
import com.elsys.easybooker.repositories.ServiceRepository;
import com.elsys.easybooker.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

import static com.elsys.easybooker.security.SecurityConstants.ADMIN;

public class BusinessService {

    private final BusinessRepository businessRepository;
    private final UserRepository userRepository;
    private final ServiceRepository serviceRepository;
    private final LocationRepository locationRepository;

    public BusinessService(BusinessRepository businessRepository,
                           UserRepository userRepository,
                           ServiceRepository serviceRepository,
                           LocationRepository locationRepository){
        this.userRepository = userRepository;
        this.businessRepository = businessRepository;
        this.serviceRepository = serviceRepository;
        this.locationRepository = locationRepository;
    }

    public Iterable getBusinesses() {
        return businessRepository.findAll();
    }

    public Business getBusinessById( long id) {
        return businessRepository.findById(id);
    }

    public Business createBusiness(Business business ) {

        Business businessCreated = businessRepository.save(business);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User owner = userRepository.findByUsername(auth.getName());
        businessCreated.getUserAssoc().add(new UserBusiness(owner, businessCreated, ADMIN));

        return businessCreated;
    }

    //updates either it's one business or many...
    public void updateBusinesses( List<Business> businesses) {
        businessRepository.save(businesses); // TO DO implement equals and hashcode to entities //
    }


    public void deleteBusinesses() {
        businessRepository.deleteAll();
    }

    public void deleteBusinessById(Long id) {
        businessRepository.delete(id);
    }



    public List<Service> getBusinessServices(long businessId) {
        return serviceRepository.findByBusinessId(businessId);
    }


    public List<Service> createOrUpdateBusinessServices(long businessId, List<Service> services) {
        Business business = businessRepository.findById(businessId);
        for(Service service : services){
            service.setBusiness(business);
        }
        business.getServices().addAll(services);
        businessRepository.save(business);

        return services;
    }

    public void deleteBusinessServices(long businessId) {
        serviceRepository.deleteByBusinessId(businessId);
    }


    public void deleteBusinessServiceById(long businessId, long serviceId) {
        // TO DO AUTHENTICATE IF USER HAS PERMISSIONS TO DO IT.... //
        serviceRepository.delete(serviceId);
    }




    public List<Location> getBusinessLocations(long businessId) {
       return  locationRepository.findAll();
    }


    public List<Location> createOrUpdateBusinessLocations(long businessId, List<Location> locations) {
        Business business = businessRepository.findById(businessId);
        for(Location location : locations){
            location.setBusiness(business);
        }
        business.getLocations().addAll(locations);
        businessRepository.save(business);

        return locations;
    }

    public void deleteBusinessLocations(long businessId) {
         locationRepository.deleteByBusinessId(businessId);
    }

    public void deleteBusinessLocationById(long businessId, long locationId) {
        locationRepository.delete(locationId);
    }


    public boolean isUserBusinessAdmin(long businessId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(auth.getName());

        for(UserBusiness userBusiness : user.getBusinessAssoc()){
            if(userBusiness.getBusiness().getId() == businessId 
                    && userBusiness.getPermission() == ADMIN){
                return true;
            }
        }

        return false;
    }



}
