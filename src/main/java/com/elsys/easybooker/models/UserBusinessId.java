package com.elsys.easybooker.models;

import java.io.Serializable;

public class UserBusinessId  implements Serializable{
    private long businessId;
    private long userId;

    public UserBusinessId(){}

    public UserBusinessId(long businessId, long userId){
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
        UserBusinessId other = (UserBusinessId) obj;

        if(other.getBusinessId() != this.businessId){
            return false;
        }else {
            if(other.getUserId() != this.userId){
                return false;
            }

            return true;
        }

    }

}
