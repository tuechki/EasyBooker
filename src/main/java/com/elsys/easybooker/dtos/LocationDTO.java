package com.elsys.easybooker.dtos;

import com.elsys.easybooker.models.BookingRecord;
import com.elsys.easybooker.models.Business;
import com.elsys.easybooker.models.DaySchedule;
import com.elsys.easybooker.models.Service;
import org.postgresql.util.PGInterval;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LocationDTO {

    private long id;

    private String address;

    private String number;

    private String summary;

    private String email;

    private PGInterval minTimeBetweenServices;

    private Business business;

    private List<Service> services = new ArrayList<>();

    private List<DaySchedule> scheduleOfDays = new ArrayList<>();

    private List<BookingRecord> bookingRecords = new ArrayList<>();

    public LocationDTO(){ }

    public LocationDTO(long id){
        this.id = id;
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

    public void setMinTimeBetweenServices(PGInterval minTimeBetweenServices) {
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

    public List<BookingRecord> getBookingRecords() {
        return bookingRecords;
    }

    public void setBookingRecords(List<BookingRecord> bookingRecords) {
        this.bookingRecords = bookingRecords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LocationDTO)) return false;
        LocationDTO that = (LocationDTO) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
