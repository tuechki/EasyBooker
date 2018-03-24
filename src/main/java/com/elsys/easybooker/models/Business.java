package com.elsys.easybooker.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.jdbc.support.incrementer.AbstractDataFieldMaxValueIncrementer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDate;

import static com.elsys.easybooker.security.SecurityConstants.ADMIN;

@Entity
@Table(name = "businesses")
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "email")
    private String email;

    @JsonIgnore
    private LocalDateTime createdAt;

    @JsonIgnore
    private LocalDateTime editedAt;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "business")
    @JsonIgnore
    private List<Service> services = new ArrayList();

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "business")
    @JsonIgnore
    private List<Location> locations = new ArrayList<>();

    @OneToMany(mappedBy = "business")
    @JsonIgnore
    private List<UserBusiness> userAssoc = new ArrayList<>();

    public Business(){ }

    public Business(long id){
        this.id = id;
    }

    public Business(String name, String description, String email){
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getEditedAt() {
        return editedAt;
    }

    public void setEditedAt(LocalDateTime editedAt) {
        this.editedAt = editedAt;
    }

    public List<Service> getServices(){
        return this.services;
    }

    public void setServices(List<Service> services){
        this.services = services;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<UserBusiness> getUserAssoc() {
        return userAssoc;
    }

    public void setUserAssoc(List<UserBusiness> userAssoc) {
        this.userAssoc = userAssoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Business)) return false;
        Business business = (Business) o;
        return getId() == business.getId();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
