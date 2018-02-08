package com.elsys.easybooker.repositories;

import com.elsys.easybooker.models.UsersBusinesses;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface UsersBusinessesDao extends CrudRepository<UsersBusinesses, Long> {
}
