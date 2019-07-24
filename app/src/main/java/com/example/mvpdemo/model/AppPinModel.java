package com.example.mvpdemo.model;

public class AppPinModel {
    private String password;

    public AppPinModel(String password) {
        this.password = password;
    }

    public AppPinModel() {}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
