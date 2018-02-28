package com.elsys.easybooker.repositories;

import com.elsys.easybooker.models.BookingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRecordRepository extends JpaRepository<BookingRecord, Long> {
}
