package com.elsys.easybooker.repositories;

import com.elsys.easybooker.models.Business;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface BusinessRepository extends JpaRepository<Business, Long> {
    public Business findByName(String name);
    public Business findById(long id);
}
