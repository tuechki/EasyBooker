package com.elsys.easybooker.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "BookingRecords")
public class BookingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "dayNumber")
    private long dayNumber;

    @NotNull
    @Column(name = "beginTime")
    private Time beginTime  ;

    @Column(name = "cratedAt")
    private Timestamp createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    public BookingRecord(){ }

    public BookingRecord(long id){
        this.id = id;
    }

    public BookingRecord(long dayNumber, Time beginTime, Timestamp createdAt){
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
