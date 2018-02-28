package com.elsys.easybooker.repositories;

import com.elsys.easybooker.models.BookingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRecordRepository extends JpaRepository<BookingRecord, Long> {
    public List<BookingRecord> findAllByUserId(long userId);
    public List<BookingRecord> findAllByLocationId(long locationId);
    public List<BookingRecord> findAllByServiceId(long serviceId);
    public List<BookingRecord> findAllByUserIdAndLocationIdAndServiceId(long userId, long locationId, long serviceId);
}
