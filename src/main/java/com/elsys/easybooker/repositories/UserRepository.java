package com.elsys.easybooker.repositories;

import com.elsys.easybooker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);
    public User findByUsername(String username);



}
