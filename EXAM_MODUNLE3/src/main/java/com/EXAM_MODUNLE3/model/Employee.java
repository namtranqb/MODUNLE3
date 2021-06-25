package com.EXAM_MODUNLE3.model;

import java.sql.Date;

public class Employee {
    private int id;
    private String group;
    private String fullname;
    private Date dob;
    private String gender;
    private String phone_number;
    private String identity;
    private String email;
    private String address;

    public Employee() {
    }

    public Employee(int id, String group, String fullname, Date dob, String gender, String phone_number, String identity, String email, String address) {
        this.id = id;
        this.group = group;
        this.fullname = fullname;
        this.dob = dob;
        this.gender = gender;
        this.phone_number = phone_number;
        this.identity = identity;
        this.email = email;
        this.address = address;
    }

    public Employee(int id, String group, String fullname, String gender, String phone_number) {
        this.id = id;
        this.group = group;
        this.fullname = fullname;
        this.gender = gender;
        this.phone_number = phone_number;

    }
    public Employee(String group, String fullname, Date dob, String gender, String phone_number, String identity, String email, String address) {
        this.group = group;
        this.fullname = fullname;
        this.dob = dob;
        this.gender = gender;
        this.phone_number = phone_number;
        this.identity = identity;
        this.email = email;
        this.address = address;

    }


        public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
