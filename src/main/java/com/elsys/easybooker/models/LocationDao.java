package com.elsys.easybooker.models;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface LocationDao extends CrudRepository<Location, Long> {
    public Location findById(long id);
}
