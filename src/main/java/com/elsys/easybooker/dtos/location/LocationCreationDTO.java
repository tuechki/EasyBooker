package com.elsys.easybooker.dtos.location;

import com.elsys.easybooker.models.DaySchedule;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public class LocationCreationDTO {
    @NotNull
    private String address;

    @NotNull
    private String description;

    @NotNull
    private String number;

    @NotNull
    private String email;

    @NotNull
    private List<DaySchedule> dayScheduleList;

    @JsonIgnore
    private final LocalDateTime createdAt = LocalDateTime.now();

    @JsonIgnore
    private final LocalDateTime editedAt = LocalDateTime.now();


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<DaySchedule> getDayScheduleList() {
        return dayScheduleList;
    }

    public void setDayScheduleList(List<DaySchedule> dayScheduleList) {
        this.dayScheduleList = dayScheduleList;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getEditedAt() {
        return editedAt;
    }
}
