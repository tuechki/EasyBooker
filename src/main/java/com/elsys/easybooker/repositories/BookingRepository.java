package com.elsys.easybooker.repositories;

import com.elsys.easybooker.models.Booking;
import com.elsys.easybooker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    public List<Booking> findByUser(User user);
    public List<Booking> findByDate(LocalDate localDate);
}
