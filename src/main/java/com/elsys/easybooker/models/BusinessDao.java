package com.elsys.easybooker.models;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface BusinessDao extends CrudRepository<UserTry, Long> {
}
