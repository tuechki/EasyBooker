package com.elsys.easybooker.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "businessId")
    private long businessId;

    @Column(name = "summary")
    private String summary;

    @NotNull
    @Column(name = "timeDuration")
    private int timeDuration;

    @NotNull
    @Column(name = "price")
    private int price;

    public Service(){ }

    public Service(long id){
        this.id = id;
    }

    public Service(long businessId, int timeDuration, int price){
        this.businessId = businessId;
        this.timeDuration = timeDuration;
        this.price = price;

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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(int timeDuration) {
        this.timeDuration = timeDuration;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
