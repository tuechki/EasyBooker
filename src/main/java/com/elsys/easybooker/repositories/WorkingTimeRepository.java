package com.elsys.easybooker.repositories;

import com.elsys.easybooker.models.WorkingTime;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface WorkingTimeRepository extends JpaRepository<WorkingTime, Long> {

    public WorkingTime findById(long id);
    public List<WorkingTime> findByLocationId(long locationId);
    public List<WorkingTime> findByUserId(long userId);
    public List<WorkingTime> findByDayOfWeek(String dayOfWeek);
    public List<WorkingTime> findByBeginHour(String beginHour);
    public List<WorkingTime> findByEndHour(String endHour);
}
