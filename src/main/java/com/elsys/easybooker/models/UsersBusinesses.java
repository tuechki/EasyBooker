package com.elsys.easybooker.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "UsersBusinesses")
@IdClass(UsersBusinessesId.class)
public class UsersBusinesses {

    @Id @NotNull
    private long businessId;

    @Id @NotNull
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
