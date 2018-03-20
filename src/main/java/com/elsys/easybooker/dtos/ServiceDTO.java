package com.elsys.easybooker.dtos;

import org.postgresql.util.PGInterval;

import java.util.Objects;

public class ServiceDTO {

    private long id;

    private String name;

    private String summary;

    private PGInterval timeDuration;

    private double price;

    private long businessId;

    public ServiceDTO(){

    }

    public ServiceDTO(String name, String summary, PGInterval timeDuration, double price){
        this.name = name;
        this.summary = summary;
        this.timeDuration = timeDuration;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public PGInterval getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(PGInterval timeDuration) {
        this.timeDuration = timeDuration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
        if (!(o instanceof ServiceDTO)) return false;
        ServiceDTO that = (ServiceDTO) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
