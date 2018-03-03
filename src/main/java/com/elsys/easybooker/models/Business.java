package com.elsys.easybooker.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Businesses")
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

    @OneToMany
    private List<Service> services = new ArrayList<>();

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

    public void addServices(Service service){
        this.services.add(service);
    }
}
