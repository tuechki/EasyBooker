package com.elsys.easybooker.models;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UserTryDao extends CrudRepository<UserTry, Long> {
    public UserTry findByUsername(String username);
}