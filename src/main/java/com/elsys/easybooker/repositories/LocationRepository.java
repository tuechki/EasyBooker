package com.elsys.easybooker.repositories;

import com.elsys.easybooker.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface LocationRepository extends JpaRepository<Location, Long> {
    public Location findById(long id);
}
