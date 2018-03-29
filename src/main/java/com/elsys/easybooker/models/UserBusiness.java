package com.elsys.easybooker.models;

import com.elsys.easybooker.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "users_businesses")
@IdClass(UserBusinessId.class)
public class UserBusiness {

    @Id
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Id
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "business_id", referencedColumnName = "id")
    private Business business;

    @NotNull
    @Column(name = "role")
    private Role role;

    public UserBusiness(){}

    public UserBusiness(User user, Business business, Role role){
        this.user = user;
        this.business = business;
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserBusiness)) return false;
        UserBusiness that = (UserBusiness) o;
        return getRole() == that.getRole() &&
                Objects.equals(getUser(), that.getUser()) &&
                Objects.equals(getBusiness(), that.getBusiness());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getUser(), getBusiness(), getRole());
    }
}
