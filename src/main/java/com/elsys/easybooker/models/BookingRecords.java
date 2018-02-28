package com.elsys.easybooker.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.postgresql.util.PGInterval;

import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "BookingRecords")
public class BookingRecords {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "userId")
    private long userId;

    @NotNull
    @Column(name = "locationId")
    private long locationId;

    @Column(name = "serviceId")
    private long serviceId;

    @Column(name = "dayNumber")
    private long dayNumber;

    @NotNull
    @Column(name = "beginTime")
    private Time beginTime  ;

    @Column(name = "cratedAt")
    private Timestamp createdAt;

    public BookingRecords(){ }

    public BookingRecords(long id){
        this.id = id;
    }

    public BookingRecords(long userId, long locationId, long serviceId, long dayNumber, Time beginTime, Timestamp createdAt){
        this.userId = userId;
        this.locationId = locationId;
        this.serviceId = serviceId;
        this.dayNumber = dayNumber;
        this.beginTime = beginTime;
        this.createdAt = createdAt;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
    }

    public long getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(long dayNumber) {
        this.dayNumber = dayNumber;
    }

    public Time getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Time beginTime) {
        this.beginTime = beginTime;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
