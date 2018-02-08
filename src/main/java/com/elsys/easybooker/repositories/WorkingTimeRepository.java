package com.elsys.easybooker.repositories;

import com.elsys.easybooker.models.WorkingTime;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface WorkingTimeRepository extends JpaRepository<WorkingTime, Long> {
}
