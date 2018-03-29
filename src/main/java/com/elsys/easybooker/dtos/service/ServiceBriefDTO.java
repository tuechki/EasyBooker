package com.elsys.easybooker.dtos.service;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class ServiceBriefDTO {
    @Id
    @NotNull
    private long id;

    @NotNull
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
