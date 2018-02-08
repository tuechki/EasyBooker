package com.elsys.easybooker.repositories;

import com.elsys.easybooker.models.WorkingTime;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface WorkingTimeDao extends CrudRepository<WorkingTime, Long> {
}
