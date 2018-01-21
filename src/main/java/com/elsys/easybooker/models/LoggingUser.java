package com.elsys.easybooker.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.awt.*;
import java.sql.Date;

public class LoggingUser {

    private String username;

    private String password;

    public LoggingUser(){ }

    public LoggingUser( String username, String password){
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


}
