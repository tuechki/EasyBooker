package com.elsys.easybooker.dtos.location;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class LocationUpdateDTO {
    @Id
    @NotNull
    private long id;

    @NotNull
    private String address;

    @NotNull
    private String description;

    @NotNull
    private String number;

    @NotNull
    private String email;

    @NotNull
    private long businessId;

    @NotNull
    private String businessName;

    @JsonIgnore
    private final LocalDateTime editedAt = LocalDateTime.now();

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

    public LocalDateTime getEditedAt() {
        return editedAt;
    }

    public long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(long businessId) {
        this.businessId = businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
}
