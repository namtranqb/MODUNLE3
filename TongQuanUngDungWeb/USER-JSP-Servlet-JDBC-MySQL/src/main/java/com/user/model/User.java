package com.user.model;

public class User {
    protected int id;
    protected String fullName;
    protected String email;
    protected String country;

    public User() {
    }

    public User(int id, String fullName, String email, String country) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.country = country;
    }

    public User(String fullName, String email, String country) {
        this.fullName = fullName;
        this.email = email;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

