package com.elsys.easybooker.repositories;

import com.elsys.easybooker.enums.WeekDay;
import com.elsys.easybooker.models.DaySchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DayScheduleRepository extends JpaRepository<DaySchedule, Long>{
    public List<DaySchedule> findAllByLocationId(long locationId);
    public DaySchedule findByLocationIdAndWeekDay(long locationId, WeekDay weekDay);
}
