package com.elsys.easybooker.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "LocationsServices")
@IdClass(LocationsServicesId.class)
public class LocationsServices {
    @Id @NotNull
    @Column(name = "locationId")
    private long locationId;

    @Id @NotNull
    @Column(name = "serviceId")
    private long serviceId;

    public LocationsServices(){ }

    public LocationsServices(long locationId, long serviceId){
        this.locationId = locationId;
        this.serviceId = serviceId;

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

}
