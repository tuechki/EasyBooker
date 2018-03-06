package com.elsys.easybooker.repositories;

import com.elsys.easybooker.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface LocationRepository extends JpaRepository<Location, Long> {
    public Location findById(long id);
    public List<Location> findByBusinessId(long businessId);
    public Location findByAddress(String address);
    public Location findByNumber(String number);
    public Location findByEmail(String email);
    public List<Location> deleteByBusinessId(long businessId);
}
