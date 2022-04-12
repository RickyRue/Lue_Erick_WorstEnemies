package com.erick.lue.casestudy.worstenemies.services;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


public class UserRegistrationDto {

    @NotEmpty
    private String userName;

    @NotEmpty
    private String password;


    @Email
    @NotEmpty
    private String email;



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

