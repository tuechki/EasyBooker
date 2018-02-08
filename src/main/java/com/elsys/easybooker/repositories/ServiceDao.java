package com.elsys.easybooker.repositories;

import com.elsys.easybooker.models.Service;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ServiceDao extends CrudRepository<Service, Long> {
    public Service findById(long id);
    public Service findByName(String name);
    public List<Service> findByBusinessId(long businessId);
}
