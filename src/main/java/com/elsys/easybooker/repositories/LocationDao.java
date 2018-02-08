package com.elsys.easybooker.repositories;

import com.elsys.easybooker.models.Location;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface LocationDao extends CrudRepository<Location, Long> {
    public Location findById(long id);
}
