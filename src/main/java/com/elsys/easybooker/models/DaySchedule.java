package com.elsys.easybooker.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.postgresql.util.PGInterval;

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
    @Column(name = "dayOfWeek")
    private int dayOfWeek;

    @Column(name = "openTime")
    private Time openTime;

    @NotNull
    @Column(name = "CloseTime")
    private Time closeTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    public DaySchedule(){ }

    public DaySchedule(long id){
        this.id = id;
    }


    public DaySchedule(int dayOfWeek, Time openTime, Time closeTime){
        this.dayOfWeek = dayOfWeek;
        this.openTime = openTime;
        this.closeTime = closeTime;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
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
                getDayOfWeek() == that.getDayOfWeek() &&
                Objects.equals(getLocation(), that.getLocation());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getDayOfWeek(), getLocation());
    }
}
