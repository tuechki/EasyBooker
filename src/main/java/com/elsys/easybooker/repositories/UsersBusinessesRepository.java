package com.elsys.easybooker.repositories;

import com.elsys.easybooker.models.UsersBusinesses;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UsersBusinessesRepository extends JpaRepository<UsersBusinesses, Long> {
    public List<UsersBusinesses> findByBusinessId(long businessId);
    public List<UsersBusinesses> findByUserId(long userId);
    public List<UsersBusinesses> findByPermission(long permission);
}
