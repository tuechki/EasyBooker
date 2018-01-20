package com.elsys.easybooker.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "businessId")
    private long businessId;

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

    public Location(){ }

    public Location(long id){
        this.id = id;
    }

    public Location(long businessId, String address, String summary, String email){
        this.businessId = businessId;
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

    public long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(long businessId) {
        this.businessId = businessId;
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

}
