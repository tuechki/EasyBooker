package com.elsys.easybooker.repositories;

import com.elsys.easybooker.models.UserBusiness;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UsersBusinessesRepository extends JpaRepository<UserBusiness, Long> {
    public List<UserBusiness> findByBusinessId(long businessId);
    public List<UserBusiness> findByUserId(long userId);
    public List<UserBusiness> findByPermission(long permission);
}
