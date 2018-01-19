package com.elsys.easybooker.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.awt.*;
import java.sql.Date;

@Entity
@Table(name = "UsersTry")
public class UserTry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "username")
    private String username;

    @NotNull
    @Column(name = "password")
    private String password;

    public UserTry(){ }

    public UserTry(long id){
        this.id = id;
    }

    public UserTry( String username, String password){
        this.username = username;
        this.password = password;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
