package com.elsys.easybooker.models;

import java.io.Serializable;

public class UsersBusinessesId  implements Serializable{
    private long businessId;
    private long userId;

    public UsersBusinessesId(){}

    public UsersBusinessesId(long businessId, long userId){
        this.businessId = businessId;
        this.userId = userId;
    }

    public long getBusinessId() {
        return businessId;
    }

    public long getUserId() {
        return userId;
    }

    @Override
    public int hashCode() {
        Long locationIdLong = new Long(businessId);
        Long serviceIdLong = new Long(userId);
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

        if(other.getLocationId() != this.businessId){
            return false;
        }else {
            if(other.getServiceId() != this.userId){
                return false;
            }

            return true;
        }

    }

}
