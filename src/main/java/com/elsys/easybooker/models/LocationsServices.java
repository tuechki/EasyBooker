package com.elsys.easybooker.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "LocationsServices")
public class LocationsServices {

    @NotNull
    private long locationId;

    @NotNull
    private long serviceId;

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
