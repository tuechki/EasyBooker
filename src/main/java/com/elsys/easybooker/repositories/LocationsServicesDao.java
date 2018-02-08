package com.elsys.easybooker.repositories;

import com.elsys.easybooker.models.LocationsServices;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface LocationsServicesDao extends CrudRepository<LocationsServices, Long> {
}
