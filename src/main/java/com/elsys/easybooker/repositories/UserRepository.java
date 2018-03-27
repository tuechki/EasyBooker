package com.elsys.easybooker.repositories;

import com.elsys.easybooker.enums.Role;
import com.elsys.easybooker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.jws.soap.SOAPBinding;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

     User findById(long id);
     User findByUsername(String username);
     List<User> findByFirstName(String firstName);
     List<User> findByLastName(String lastName);
     User findByEmail(String email);
     void deleteById(long id);
     void deleteByUsername(String username);

}
