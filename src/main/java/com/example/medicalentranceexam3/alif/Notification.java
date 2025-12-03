package com.example.medicalentranceexam3.alif;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Notification implements Serializable {
    private String notificationID;
    private String applicantID;
    private String message;
    private LocalDateTime timestamp;

    public Notification(String notificationID, String applicantID, String message) {
        this.notificationID = notificationID;
        this.applicantID = applicantID;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public String getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(String notificationID) {
        this.notificationID = notificationID;
    }

    public String getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(String applicantID) {
        this.applicantID = applicantID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationID='" + notificationID + '\'' +
                ", applicantID='" + applicantID + '\'' +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}