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

    private long businessId;

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

    public long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(long businessId) {
        this.businessId = businessId;
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
