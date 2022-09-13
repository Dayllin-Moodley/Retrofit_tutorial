package com.example.retrofit_tutorial;

public class Loginrequest {

    private String P_Email;
    private String UserPassword;

    public String getEmail() {
        return P_Email;
    }

    public void setEmail(String email) {
        this.P_Email = email;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }
}
