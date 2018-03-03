package com.elsys.easybooker.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.postgresql.util.PGInterval;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id", nullable = false)
    private Business business;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "services")
    private List<Location> locations = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "service")
    private List<BookingRecord> bookingRecords = new ArrayList<>();

    public Service(){ }

    public Service(long id){
        this.id = id;
    }

   public Service(String name, PGInterval timeDuration, int price){
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

    public Business getBusiness(){
        return business;
    }

    public void setBusiness(Business business){
        this.business = business;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<BookingRecord> getBookingRecords() {
        return bookingRecords;
    }

    public void setBookingRecords(List<BookingRecord> bookingRecords) {
        this.bookingRecords = bookingRecords;
    }
}
