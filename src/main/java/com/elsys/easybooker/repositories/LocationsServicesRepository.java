package com.elsys.easybooker.repositories;

import com.elsys.easybooker.models.LocationsServices;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface LocationsServicesRepository extends JpaRepository<LocationsServices, Long> {
    public List<LocationsServices> findByLocationId(long locationId);
    public List<LocationsServices> findByServiceId(long serviceId);
}
