package com.elsys.easybooker.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;

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

    @Column(name = "summary")
    private String summary;

    @NotNull
    @Column(name = "email")
    private String email;

    @Lob
    @Column(name="image")
    private byte[] image;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "business")
    private List<Service> services = new ArrayList();

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "business")
    private List<Location> locations = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserBusiness> userAssoc;

    public Business(){ }

    public Business(long id){
        this.id = id;
    }

    public Business(String name, String summary, String email, byte[] image){
        this.name = name;
        this.summary = summary;
        this.email = email;
        this.image = image;

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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPic() {
        return image;
    }

    public void setPic(byte[] pic) {
        this.image = pic;
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
