package com.elsys.easybooker.dtos.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.postgresql.util.PGInterval;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ServiceUpdateDTO {

    @Id
    @NotNull
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private PGInterval timeDuration;

    @NotNull
    private double price;

    @JsonIgnore
    private final LocalDateTime editedAt = LocalDateTime.now();

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

    public PGInterval getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(PGInterval timeDuration) {
        this.timeDuration = timeDuration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getEditedAt() {
        return editedAt;
    }
}
