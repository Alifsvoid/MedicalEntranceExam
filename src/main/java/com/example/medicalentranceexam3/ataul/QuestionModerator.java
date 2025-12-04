package com.example.medicalentranceexam3.ataul;

import java.io.Serializable;

public class QuestionModerator implements Serializable {
    private String moderatorID;      // Unique ID for moderator
    private String name;             // Moderator name
    private String email;            // Email for contact
    private String phone;            // Phone number
    private String assignedExamID;   // Which exam he/she moderates
    private String subject;
    private String password;// Optional subject field

    public QuestionModerator(String moderatorID, String name, String email,
                             String phone, String assignedExamID, String subject, String password) {
        this.moderatorID = moderatorID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.assignedExamID = assignedExamID;
        this.subject = subject;
        this.password = password;
    }

    // Getters & Setters
    public String getModeratorID() {
        return moderatorID;
    }

    public void setModeratorID(String moderatorID) {
        this.moderatorID = moderatorID;
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

    public String getAssignedExamID() {
        return assignedExamID;
    }

    public void setAssignedExamID(String assignedExamID) {
        this.assignedExamID = assignedExamID;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return moderatorID + " - " + name;
    }
}
