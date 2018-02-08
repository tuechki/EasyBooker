package com.elsys.easybooker.repositories;

import com.elsys.easybooker.models.Business;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface BusinessDao extends CrudRepository<Business, Long> {
    public Business findByName(String name);
    public Business findById(long id);
}
