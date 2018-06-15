package com.elsys.easybooker.repositories;

import com.elsys.easybooker.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    public List<Booking> findByUser(User user);
    public List<Booking> findByDate(LocalDate localDate);
    public List<Booking> findByDateAndLocation(LocalDate localDate, Location location);
    public List<Booking> findByLocation(Location location);
    public List<Booking> findByService(Service service);
    public List<Booking> findByBusiness(Business business);
}
