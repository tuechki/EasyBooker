package com.elsys.easybooker.models;

import com.elsys.easybooker.enums.WeekDay;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "day_schedules")
public class DaySchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "weekDay")
    private WeekDay weekDay;

    @Column(name = "openTime")
    private Time openTime;

    @Column(name = "CloseTime")
    private Time closeTime;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    @JsonIgnore
    private Location location;

    public DaySchedule(){ }

    public DaySchedule(long id){
        this.id = id;
    }


    public DaySchedule(WeekDay weekDay, Time openTime, Time closeTime){
        this.weekDay = weekDay;
        this.openTime = openTime;
        this.closeTime = closeTime;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public Time getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Time openTime) {
        this.openTime = openTime;
    }

    public Time getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Time closeTime) {
        this.closeTime = closeTime;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DaySchedule)) return false;
        DaySchedule that = (DaySchedule) o;
        return getId() == that.getId() &&
                getWeekDay() == that.getWeekDay() &&
                Objects.equals(getLocation(), that.getLocation());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getWeekDay(), getLocation());
    }
}
