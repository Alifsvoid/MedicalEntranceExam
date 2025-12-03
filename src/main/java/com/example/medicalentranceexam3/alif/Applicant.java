package com.example.medicalentranceexam3.alif;

import java.io.Serializable;
import java.time.LocalDate;

public class Applicant implements Serializable {
    // Basic personal info
    private String applicantID;   // unique ID
    private String name;
    private LocalDate dob;           // or LocalDate dob;
    private String phone;
    private String email;
    private String feePaid;
    private String password;

    public Applicant(String applicantID, String name, LocalDate dob, String phone, String email, String password) {
        this.applicantID = applicantID;
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.feePaid = "Due";
    }


    public String getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(String applicantID) {
        this.applicantID = applicantID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getFeePaid() {
        return feePaid;
    }

    public void setFeePaid(String feePaid) {
        this.feePaid = feePaid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "applicantID='" + applicantID + '\'' +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", feePaid=" + feePaid +
                '}';
    }
}
