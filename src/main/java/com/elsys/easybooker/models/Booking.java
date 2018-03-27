package com.elsys.easybooker.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "booking_records")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookingRecord)) return false;
        BookingRecord that = (BookingRecord) o;
        return getId() == that.getId() &&
                getDayNumber() == that.getDayNumber() &&
                Objects.equals(getBeginTime(), that.getBeginTime()) &&
                Objects.equals(getUser(), that.getUser()) &&
                Objects.equals(getLocation(), that.getLocation()) &&
                Objects.equals(getService(), that.getService());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getDayNumber(), getBeginTime(), getUser(), getLocation(), getService());
    }
}
