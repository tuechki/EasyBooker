package com.elsys.easybooker.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.postgresql.util.PGInterval;

import java.sql.Time;

@Entity
@Table(name = "DaySchedule")
public class DaySchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "locationId")
    private long locationId;

    @NotNull
    @Column(name = "dayOfWeek")
    private int dayOfWeek;

    @Column(name = "openTime")
    private Time openTime;

    @NotNull
    @Column(name = "CloseTime")
    private Time closeTime;

    public DaySchedule(){ }

    public DaySchedule(long id){
        this.id = id;
    }


    public DaySchedule(long locationIdId,
                   int dayOfWeek, Time openTime, Time closeTime){
        this.locationId = locationIdId;
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

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
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
}
