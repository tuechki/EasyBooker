package com.elsys.easybooker.repositories;

import com.elsys.easybooker.models.BookRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRecordRepository extends JpaRepository<BookRecord, Long> {

}
