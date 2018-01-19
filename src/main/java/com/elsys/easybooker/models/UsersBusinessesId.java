package com.elsys.easybooker.models;

public class UsersBusinessesId {
    private long businessId;
    private long userId;

    public UsersBusinessesId(long businessId, long userId){
        this.businessId = businessId;
        this.userId = userId;
    }

    public long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(long businessId) {
        this.businessId = businessId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
