package com.elsys.easybooker.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "firstName")
    private String firstName;

    @NotNull
    @Column(name = "lastName")
    private String lastName;

    @NotNull
    @Column(name = "userName")
    private String username;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private String gender;

//    private Date dateOfBirth;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<UserBusiness> businessAssoc = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private List<Booking> bookings = new ArrayList<>();

    @JsonIgnore
    private LocalDateTime createdAt;

    @JsonIgnore
    private  LocalDateTime editedAt;


    public User(){ }

    public User(long id){
        this.id = id;
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User(String firstName, String lastName, String username, String password, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(String firstName, String lastName, String username,
                String password, String email, String gender){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
//        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName(){
        return this.firstName.concat(this.lastName);
    }

    public List<UserBusiness> getBusinessAssoc() {
        return businessAssoc;
    }

    public void setBusinessAssoc(List<UserBusiness> businessAssoc) {
        this.businessAssoc = businessAssoc;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                Objects.equals(getUsername(), user.getUsername()) &&
                Objects.equals(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getUsername(), getEmail());
    }
}
