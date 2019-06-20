package com.example.myapplication;

import java.util.Date;

public class User {
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String Address;
    public Date CreateDate;
    private static User instance;

    private User(){}

    public static synchronized User getInstance(){
        if (instance == null){
            instance = new User();
        }
        return instance;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
}
