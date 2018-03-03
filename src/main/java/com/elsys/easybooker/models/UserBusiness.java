package com.elsys.easybooker.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "UsersBusinesses")
@IdClass(UserBusinessId.class)
public class UserBusiness {

    @Id @NotNull
    @Column(name = "businessId")
    private long businessId;

    @Id @NotNull
    @Column(name = "userId")
    private long userId;

    @NotNull
    @Column(name = "permission")
    private int permission;

    public UserBusiness(){}

    public UserBusiness(long businessId, long userId, int permission){
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
