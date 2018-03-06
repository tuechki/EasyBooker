package com.elsys.easybooker.services;

import com.elsys.easybooker.models.*;
import com.elsys.easybooker.repositories.BusinessRepository;
import com.elsys.easybooker.repositories.LocationRepository;
import com.elsys.easybooker.repositories.ServiceRepository;
import com.elsys.easybooker.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedClientException;

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

    public Business getBusinessById( long businessId) {
        return businessRepository.findById(businessId);
    }

    public void createBusiness(Business business ) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User owner = userRepository.findByUsername(auth.getName());

        Business businessCreated = businessRepository.save(business);
        businessCreated.getUserAssoc().add(new UserBusiness(owner, businessCreated, ADMIN));

    }

    public void updateBusiness( Business business) throws UnauthorizedClientException{
        if(isUserBusinessAdmin(business.getId())){
            businessRepository.save(business);
        }

         // TO DO implement equals and hashcode to entities //
    }


    public void deleteBusinessById(Long id) throws UnauthorizedClientException {
        if(isUserBusinessAdmin(id)) {
            businessRepository.delete(id);
        }
    }



    public List<Service> getBusinessServices(long businessId) {
        return serviceRepository.findByBusinessId(businessId);
    }


    public void createOrUpdateBusinessServices(long businessId, List<Service> services) throws UnauthorizedClientException{
        if(isUserBusinessAdmin(businessId)) {
            Business business = businessRepository.findById(businessId);
            for (Service service : services) {
                service.setBusiness(business);
            }
            business.getServices().addAll(services);
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
            }
            business.getLocations().addAll(locations);
            businessRepository.save(business);

        }
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
