package com.example.medicalentranceexam3.alif;

import java.io.Serializable;
import java.time.LocalDate;

public class AppliedExam implements Serializable {
    private String applicationID;   // Unique ID for this application
    private String applicantID;     // Link to applicant
    private String applicantName;   // Optional, for easier display
    private String examID;          // Exam the applicant applied for
    private String examName;        // Optional exam name
    private LocalDate applicationDate; // Date when applicant applied
    private String isApproved;     // Whether accountant approved the application

    public AppliedExam(String applicationID, String applicantID, String applicantName,
                       String examID, String examName, LocalDate applicationDate) {
        this.applicationID = applicationID;
        this.applicantID = applicantID;
        this.applicantName = applicantName;
        this.examID = examID;
        this.examName = examName;
        this.applicationDate = applicationDate;
        this.isApproved = "Pending"; // default false
    }

    // Getters and Setters
    public String getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    public String getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(String applicantID) {
        this.applicantID = applicantID;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getExamID() {
        return examID;
    }

    public void setExamID(String examID) {
        this.examID = examID;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String isApproved() {
        return isApproved;
    }

    public void setApproved(String approved) {
        isApproved = approved;
    }

    @Override
    public String toString() {
        return "AppliedExam{" +
                "applicationID='" + applicationID + '\'' +
                ", applicantID='" + applicantID + '\'' +
                ", applicantName='" + applicantName + '\'' +
                ", examID='" + examID + '\'' +
                ", examName='" + examName + '\'' +
                ", applicationDate=" + applicationDate +
                ", isApproved=" + isApproved +
                '}';
    }
}
