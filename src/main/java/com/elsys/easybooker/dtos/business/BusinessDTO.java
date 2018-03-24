package com.elsys.easybooker.dtos.business;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class BusinessDTO {
    @Id
    @NotNull
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String email;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
