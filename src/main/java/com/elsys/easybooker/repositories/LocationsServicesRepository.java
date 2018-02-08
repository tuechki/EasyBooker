package com.elsys.easybooker.repositories;

import com.elsys.easybooker.models.LocationsServices;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface LocationsServicesRepository extends JpaRepository<LocationsServices, Long> {
}
