package com.elsys.easybooker.models;

import java.io.Serializable;

public class LocationsServicesId implements Serializable{
    private long locationId;
    private long serviceId;

    public LocationsServicesId(){}

    public LocationsServicesId(long locationId, long serviceId){
        this.locationId = locationId;
        this.serviceId = serviceId;

    }

    public long getLocationId() {
        return locationId;
    }

    public long getServiceId() {
        return serviceId;
    }

    @Override
    public int hashCode() {
        Long locationIdLong = new Long(locationId);
        Long serviceIdLong = new Long(serviceId);
        final int prime = 31;
        int result = 1;
        result = prime * result + locationIdLong.hashCode();
        result = prime * result + serviceIdLong.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LocationsServicesId other = (LocationsServicesId) obj;

        if(other.getLocationId() != this.locationId){
            return false;
        }else {
            if(other.getServiceId() != this.serviceId){
                return false;
            }

            return true;
        }

    }

}
