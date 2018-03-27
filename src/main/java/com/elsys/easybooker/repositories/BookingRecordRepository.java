package com.elsys.easybooker.repositories;

import com.elsys.easybooker.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRecordRepository extends JpaRepository<Booking, Long> {

}
