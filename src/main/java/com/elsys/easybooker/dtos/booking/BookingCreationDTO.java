package com.elsys.easybooker.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingCreationDTO {
    @NotNull
    private long businessId;

    @NotNull
    private long locationId;

    @NotNull
    private long serviceId;

    private LocalDate date;

    @NotNull
    private Time beginTime  ;

    @JsonIgnore
    private final LocalDateTime createdAt = LocalDateTime.now();

    public long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(long businessId) {
        this.businessId = businessId;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Time getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Time beginTime) {
        this.beginTime = beginTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}
