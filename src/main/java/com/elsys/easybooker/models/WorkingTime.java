package com.elsys.easybooker.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "WorkingTime")
public class WorkingTime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "locationId")
    private long locationId;

    @NotNull
    @Column(name = "userId")
    private long userId;

    @NotNull
    @Column(name = "dayOfWeek")
    private String dayOfWeek;

    @NotNull
    @Column(name = "beginHour")
    private String beginHour;

    @NotNull
    @Column(name = "endHour")
    private String endHour;

    public WorkingTime(long locationId, long userId, String dayOfWeek, String beginHour, String endHour){
        this.locationId = locationId;
        this.userId = userId;
        this.dayOfWeek = dayOfWeek;
        this.beginHour = beginHour;
        this.endHour = endHour;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getBeginHour() {
        return beginHour;
    }

    public void setBeginHour(String beginHour) {
        this.beginHour = beginHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }
}
