package com.example.medicalentranceexam3.alif;

import java.time.LocalDate;

public class Applicant {
    // Basic personal info
    private String applicantID;   // unique ID
    private String name;
    private String dob;           // or LocalDate dob;
    private String phone;
    private String email;
    private boolean feePaid;

    public Applicant(String applicantID, String name, String dob, String phone, String email, boolean feePaid) {
        this.applicantID = applicantID;
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.feePaid = feePaid;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
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

    public boolean isFeePaid() {
        return feePaid;
    }

    public void setFeePaid(boolean feePaid) {
        this.feePaid = feePaid;
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
