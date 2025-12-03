package com.example.medicalentranceexam3.alif;

import java.io.Serializable;

public class Accountant implements Serializable {
    private String accountantID;
    private String name;
    private String email;
    private String phone;
    private String password;

    public Accountant(String accountantID, String name, String email, String phone, String password) {
        this.accountantID = accountantID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    // Getters and Setters
    public String getAccountantID() {
        return accountantID;
    }

    public void setAccountantID(String accountantID) {
        this.accountantID = accountantID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Accountant{" +
                "accountantID='" + accountantID + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
