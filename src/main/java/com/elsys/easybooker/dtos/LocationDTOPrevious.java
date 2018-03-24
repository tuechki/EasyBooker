package com.elsys.easybooker.dtos;

import com.elsys.easybooker.models.DaySchedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LocationDTOPrevious {

    private long id;

    private String address;

    private String number;

    private String description;

    private String email;

    private long businessId;

    private List<DaySchedule> schedulesOfDays = new ArrayList<>();

    public LocationDTOPrevious(){ }

    public LocationDTOPrevious(long id){
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

    public long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(long businessId) {
        this.businessId = businessId;
    }

    public List<DaySchedule> getSchedulesOfDays() {
        return schedulesOfDays;
    }

    public void setSchedulesOfDays(List<DaySchedule> schedulesOfDays) {
        this.schedulesOfDays = schedulesOfDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LocationDTOPrevious)) return false;
        LocationDTOPrevious that = (LocationDTOPrevious) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
