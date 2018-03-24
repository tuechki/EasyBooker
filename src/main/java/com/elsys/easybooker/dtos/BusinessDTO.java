package com.elsys.easybooker.dtos;

import java.util.Objects;

public class BusinessDTO {

    private long id;

    private String name;

    private String description;

    private String email;

    public BusinessDTO(){

    }

    public BusinessDTO(String name, String description, String email){
        this.name = name;
        this.description = description;
        this.email = email;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BusinessDTO)) return false;
        BusinessDTO that = (BusinessDTO) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getEmail());
    }
}
