package com.model;

public class Customer {
    private String name,dob,adress;

    public Customer() {
    }

    public Customer(String name, String dob, String adress) {
        this.name = name;
        this.dob = dob;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
