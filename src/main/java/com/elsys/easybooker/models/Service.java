package com.elsys.easybooker.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.postgresql.util.PGInterval;

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

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "summary")
    private String summary;

    @NotNull
    @Column(name = "timeDuration")
    private PGInterval timeDuration;

    @NotNull
    @Column(name = "price")
    private int price;

    public Service(){ }

    public Service(long id){
        this.id = id;
    }


    public Service(long businessId, String name, PGInterval timeDuration, int price){
        this.businessId = businessId;
        this.name = name;
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

    public PGInterval getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(PGInterval timeDuration) {
        this.timeDuration = timeDuration;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
