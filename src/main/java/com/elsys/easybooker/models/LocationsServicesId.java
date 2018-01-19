package com.elsys.easybooker.models;

public class LocationsServicesId {
    private long locationId;
    private long serviceId;

    public LocationsServicesId(long locationId, long serviceId){
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
