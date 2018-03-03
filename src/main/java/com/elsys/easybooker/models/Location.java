package com.elsys.easybooker.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.postgresql.util.PGInterval;

import java.util.*;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "address")
    private String address;

    @Column(name = "number")
    private String number;

    @Column(name = "summary")
    private String summary;

    @NotNull
    @Column(name = "email")
    private String email;

    @Column(name = "minTimeBetweenServices")
    private PGInterval minTimeBetweenServices;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id", nullable = false)
    private Business business;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "locations_services",
            joinColumns = { @JoinColumn(name = "location_id") },
            inverseJoinColumns = { @JoinColumn(name = "service_id") })
    private List<Service> services = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "location")
    private List<DaySchedule> scheduleOfDays = new ArrayList<>();

//    @OneToMany(cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY,
//            mappedBy = "location1")
//    private List<BookingRecord> bookingRecords = new ArrayList<>();

    public Location(){ }

    public Location(long id){
        this.id = id;
    }

    public Location(String address, String summary, String email){
        this.address = address;
        this.summary = summary;
        this.email = email;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PGInterval getMinTimeBetweenServices() {
        return minTimeBetweenServices;
    }

    public void setMinTimeBetweenServices(PGInterval minTimeBetweenServices){
        this.minTimeBetweenServices = minTimeBetweenServices;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<DaySchedule> getScheduleOfDays() {
        return scheduleOfDays;
    }

    public void setScheduleOfDays(List<DaySchedule> scheduleOfDays) {
        this.scheduleOfDays = scheduleOfDays;
    }

//    public List<BookingRecord> getBookingRecords() {
//        return bookingRecords;
//    }
//
//    public void setBookingRecords(List<BookingRecord> bookingRecords) {
//        this.bookingRecords = bookingRecords;
//    }
}
