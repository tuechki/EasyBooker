package com.elsys.easybooker.repositories;

import com.elsys.easybooker.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ServiceRepository extends JpaRepository<Service, Long> {
    public Service findById(long id);
    public Service findByName(String name);
    public List<Service> findByBusinessId(long businessId);
}
