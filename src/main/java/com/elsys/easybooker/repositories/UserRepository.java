package com.elsys.easybooker.repositories;

import com.elsys.easybooker.enums.Role;
import com.elsys.easybooker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.jws.soap.SOAPBinding;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    public User findById(long id);
    public User findByUsername(String username);
    public List<User> findByFirstName(String firstName);
    public List<User> findByLastName(String lastName);
    public User findByEmail(String email);
    public User findByGender(Role role);
    public void deleteById(long id);
    public void deleteByUsername(String username);

}
