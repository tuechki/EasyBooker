package com.elsys.easybooker.repositories;

import com.elsys.easybooker.models.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserDao extends CrudRepository<User, Long> {

    public User findByEmail(String email);
    public User findByUsername(String username);



}
