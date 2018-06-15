package com.elsys.easybooker.services;

import com.elsys.easybooker.dtos.booking.BookingBriefDTO;
import com.elsys.easybooker.dtos.business.BusinessBriefDTO;
import com.elsys.easybooker.dtos.location.LocationBriefDTO;
import com.elsys.easybooker.dtos.location.LocationDTO;
import com.elsys.easybooker.dtos.location.LocationUpdateDTO;
import com.elsys.easybooker.dtos.service.ServiceBriefDTO;
import com.elsys.easybooker.enums.Role;
import com.elsys.easybooker.enums.WeekDay;
import com.elsys.easybooker.models.*;
import com.elsys.easybooker.repositories.*;
import org.modelmapper.ModelMapper;
import org.postgresql.util.PGInterval;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedClientException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@org.springframework.stereotype.Service
public class LocationService {

    private final Path rootLocationImagesLocation = Paths.get("src\\main\\resources\\static\\images\\locations");
    private final ServiceRepository serviceRepository;
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;
    private final DayScheduleRepository dayScheduleRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public LocationService(
                           ServiceRepository serviceRepository,
                           LocationRepository locationRepository,
                           UserRepository userRepository,
                           BookingRepository bookingRepository,
                           DayScheduleRepository dayScheduleRepository){
        this.serviceRepository = serviceRepository;
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
        this.dayScheduleRepository = dayScheduleRepository;
    }

    public List<LocationBriefDTO> getLocations() {

        List<LocationBriefDTO> locationBriefDTOList = new ArrayList<>();
        for( Location location : locationRepository.findAll()){
            locationBriefDTOList.add(modelMapper.map(location, LocationBriefDTO.class));
        }

        return locationBriefDTOList;
    }

    public LocationDTO getLocationById(long locationId){
        return modelMapper.map(locationRepository.findById(locationId), LocationDTO.class);
    }


    public List<DaySchedule> getDayScheduleForLocation(long locationId){
        return dayScheduleRepository.findAllByLocationId(locationId);
    }


    public BusinessBriefDTO getBusinessForLocation(long locationId){
        Location location = locationRepository.findById(locationId);
        return modelMapper.map(location.getBusiness(), BusinessBriefDTO.class);
    }

    public LocationBriefDTO updateLocationById(LocationUpdateDTO locationUpdateDTO){
        Location location = modelMapper.map(locationUpdateDTO, Location.class);
        if(isUserBusinessAdmin(location.getBusiness().getId())){
            locationRepository.save(location);
        }

        return modelMapper.map(location, LocationBriefDTO.class);
    }

    public void addImageToLocation(long locationId, MultipartFile image) throws IOException {

        String imageName = "image";
        String imageExtension = ".png";

        new File(this.rootLocationImagesLocation.toString() + "/" + locationId ).mkdirs();
        Files.copy(image.getInputStream(), this.rootLocationImagesLocation.resolve( locationId + "/" + imageName + imageExtension));
    }

    public void deleteLocationById(long locationId){
        if(isUserBusinessAdmin(locationRepository.findById(locationId).getBusiness().getId())){
            locationRepository.delete(locationId);
        }
    }

    public List<ServiceBriefDTO> getServicesForLocation(long locationId) {
        List<ServiceBriefDTO> serviceBriefDTOList = new ArrayList<>();
        for (Service service : locationRepository.findById(locationId).getServices()){
            serviceBriefDTOList.add(modelMapper.map(service, ServiceBriefDTO.class));
        }

        return serviceBriefDTOList;
    }

    public void addServicesToLocation(long locationId, List<Long> serviceIds) {

        Location location = locationRepository.findById(locationId);
        List<Service> servicesForLocation = new ArrayList<>();

        PGInterval minTimeBetweenServices = serviceRepository.findById(serviceIds.get(0)).getTimeDuration();

        for(Long serviceId : serviceIds){
          Service service = serviceRepository.findById(serviceId);


          if(minTimeBetweenServices.getHours() > service.getTimeDuration().getHours()){
              minTimeBetweenServices = service.getTimeDuration();
          }else{
              if(minTimeBetweenServices.getMinutes() > service.getTimeDuration().getMinutes()){
                  minTimeBetweenServices = service.getTimeDuration();
              }
          }


          service.getLocations().add(location);
          servicesForLocation.add(service);
        }

        location.setMinTimeBetweenServices(minTimeBetweenServices);
        location.setServices(servicesForLocation);
        locationRepository.save(location);

    }

    public WeekDay getDayOfWeek(String dayOfWeek){
        switch (dayOfWeek) {
            case "SUNDAY":  return WeekDay.SUNDAY;
            case "MONDAY":  return WeekDay.MONDAY;
            case "TUESDAY":  return WeekDay.TUESDAY;
            case "WEDNESDAY":  return WeekDay.WEDNESDAY;
            case "THURSDAY":  return WeekDay.THURSDAY;
            case "FRIDAY":  return WeekDay.FRIDAY;
        }

        return WeekDay.SATURDAY;
    }

//    public List<Time> returnHours(List<Booking> bookings, Time beginTime, Time endTime, PGInterval minTimeBetweenServices){
//        for (; beginTime.getTime() < endTime.getTime(); beginTime.)
//    }

    public List<LocalTime> freeHours(Location location, LocalDate localDate, PGInterval serviceDuration){
        List<LocalTime> localTimeList = new ArrayList<>();
        DaySchedule daySchedule = dayScheduleRepository.findByLocationIdAndWeekDay(location.getId(), getDayOfWeek(localDate.getDayOfWeek().toString()));
        LocalTime beginTime = daySchedule.getOpenTime().toLocalTime();
        LocalTime endTime = daySchedule.getCloseTime().toLocalTime();

        localTimeList.add(beginTime);
        localTimeList.add(endTime);

        for(Booking booking : bookingRepository.findByDate(localDate)){
            localTimeList.add(booking.getBeginTime());
            localTimeList.add(booking.getEndTime());
            Collections.sort(localTimeList);
        }

        localTimeList.sort(new Comparator<LocalTime>() {
            @Override
            public int compare(LocalTime localTime1, LocalTime localTime2) {
                if(localTime1.equals(localTime2)){
                    return 0;
                }else if(localTime1.isBefore(localTime2)){
                    return -1;
                }
                return 1;
            }
        });

        for(LocalTime localTime : localTimeList){
            System.out.println("Tova: " +  localTime);
        }




        List<LocalTime> freeHours = new ArrayList<>();

        for(int counter = 0; counter < localTimeList.size(); counter += 2){
            for(LocalTime bookingTime = localTimeList.get(counter);
                bookingTime.plusHours(serviceDuration.getHours())
                        .plusMinutes(serviceDuration.getMinutes())
                        .isBefore(localTimeList.get(counter + 1))
                                ||
                        bookingTime.plusHours(serviceDuration.getHours())
                                .plusMinutes(serviceDuration.getMinutes())
                                .equals(localTimeList.get(counter + 1));
               bookingTime = bookingTime.plusHours(location.getMinTimeBetweenServices().getHours())
                        .plusMinutes(location.getMinTimeBetweenServices().getMinutes())){


                System.out.println("Booking time: " + bookingTime);
                freeHours.add(bookingTime);

            }
        }

        return freeHours;

    }

    public List<LocalTime> getFreeHours(long locationId, long serviceId, int year, int month, int day){

        Location location = locationRepository.findById(locationId);
        PGInterval minTimeBetweenServices = location.getMinTimeBetweenServices();
        Service service = serviceRepository.findById(serviceId);
        PGInterval serviceDuration = service.getTimeDuration();
//        Business business = location.getBusiness();
//
//        return  DAYS.between(business.getCreatedAt(), dateForBooking);

        LocalDate localDate = LocalDate.of(year,month,day);
        List<DaySchedule> schedule =  dayScheduleRepository.findAllByLocationId(locationId);


        Calendar begin = Calendar.getInstance();
        begin.setTime(Date.valueOf(localDate));
        begin.add(Calendar.HOUR_OF_DAY,10);
        begin.add(Calendar.MINUTE, 30);

        Calendar end = Calendar.getInstance();
        end.setTime(Date.valueOf(localDate));
        end.add(Calendar.HOUR_OF_DAY,19);
        end.add(Calendar.MINUTE, 30);

//        Duration duration = new Duration().




        List<BookingBriefDTO> bookingBriefDTOList = new ArrayList<>();
        for(Booking booking : bookingRepository.findByDate(localDate)){
            bookingBriefDTOList.add(modelMapper.map(booking, BookingBriefDTO.class));
        }

        return freeHours(location, localDate, serviceDuration);
    }

    public List<BookingBriefDTO> getLocationBookings(long locationId){
        List<BookingBriefDTO> bookingBriefDTOList = new ArrayList<>();
        for(Booking booking : bookingRepository.findByLocation(locationRepository.findById(locationId)) ){
            bookingBriefDTOList.add(modelMapper.map(booking,BookingBriefDTO.class));
        }

        return bookingBriefDTOList;
    }


    public boolean isUserBusinessAdmin(long businessId) throws UnauthorizedClientException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(auth.getName());

        for(UserBusiness userBusiness : user.getBusinessAssoc()){
            if(userBusiness.getBusiness().getId() == businessId
                    && userBusiness.getRole() == Role.ADMIN){
                return true;
            }
        }

        throw new UnauthorizedClientException("No permissions for requested operation.");
    }

}
