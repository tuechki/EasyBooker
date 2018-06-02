package com.elsys.easybooker.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.elsys.easybooker.enums.WeekDay;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.postgresql.util.PGInterval;

import java.time.LocalDateTime;
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

    @Column(name = "description")
    private String description;

    @Column(name = "number")
    private String number;

    @NotNull
    @Column(name = "email")
    private String email;

    @Column(name = "minTimeBetweenServices")
    private PGInterval minTimeBetweenServices;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id", nullable = false)
    @JsonIgnore
    private Business business;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "locations_services",
            joinColumns = { @JoinColumn(name = "location_id") },
            inverseJoinColumns = { @JoinColumn(name = "service_id") })
    @JsonIgnore
    private List<Service> services = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "location")
    private List<DaySchedule> scheduleOfDays = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "location")
    @JsonIgnore
    private List<Booking> bookings = new ArrayList<>();

    @JsonIgnore
    private  LocalDateTime createdAt;

    @JsonIgnore
    private  LocalDateTime editedAt;

    public Location(){ }

    public Location(long id){
        this.id = id;
    }

    public Location(String address, String description, String email){
        this.address = address;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public DaySchedule getScheduleOfDays(WeekDay weekDay) {

        for(DaySchedule daySchedule : getScheduleOfDays()){
            if(daySchedule.getWeekDay().equals(weekDay)){
                return daySchedule;
            }
        }

        return null;
    }

    public void setScheduleOfDays(List<DaySchedule> scheduleOfDays) {
        this.scheduleOfDays = scheduleOfDays;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getEditedAt() {
        return editedAt;
    }

    public void setEditedAt(LocalDateTime editedAt) {
        this.editedAt = editedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return getId() == location.getId();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
