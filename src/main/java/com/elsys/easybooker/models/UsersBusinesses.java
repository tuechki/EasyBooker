package com.elsys.easybooker.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "UsersBusinesses")
public class UsersBusinesses {

    @NotNull
    private long businessId;

    @NotNull
    private long userId;

    @NotNull
    private int permission;

    public UsersBusinesses(long businessId, long userId, int permission){
        this.businessId = businessId;
        this.userId = userId;
        this.permission = permission;
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

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }
}
