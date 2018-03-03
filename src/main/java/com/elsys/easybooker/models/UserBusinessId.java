package com.elsys.easybooker.models;

import java.io.Serializable;

public class UserBusinessId  implements Serializable{
    private long user;
    private long business;

    public UserBusinessId(){}

    public UserBusinessId(long user, long business){
        this.user = user;
        this.business = business;
    }

    public long getUser() {
        return user;
    }

    public long getBusiness() {
        return business;
    }

    @Override
    public int hashCode() {
        Long locationIdLong = new Long(business);
        Long serviceIdLong = new Long(user);
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

        if(other.getBusiness() != this.business){
            return false;
        }else {
            if(other.getUser() != this.user){
                return false;
            }

            return true;
        }

    }

}
