package com.elsys.easybooker.dtos.locations;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class LocationBriefDTO {
    @Id
    @NotNull
    private long id;

    @NotNull
    private String address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
