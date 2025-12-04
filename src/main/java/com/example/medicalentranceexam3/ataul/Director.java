package com.example.medicalentranceexam3.ataul;

import java.io.Serializable;

public class Director implements Serializable {
    private String directorID;   // Unique ID for the director
    private String name;         // Full name
    private String email;        // Contact email
    private String phone;        // Contact phone
    private String department;
    private String password;// Optional: e.g., "Medical Education Board"

    public Director(String directorID, String name, String email, String phone, String department, String password) {
        this.directorID = directorID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.password = password;
    }

    // Getters & Setters
    public String getDirectorID() {
        return directorID;
    }

    public void setDirectorID(String directorID) {
        this.directorID = directorID;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return directorID + " - " + name;
    }
}
