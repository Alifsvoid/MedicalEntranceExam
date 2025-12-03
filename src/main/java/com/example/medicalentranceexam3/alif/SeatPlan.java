package com.example.medicalentranceexam3.alif;

import java.io.Serializable;

public class SeatPlan implements Serializable {
    private String seatNumber;      // e.g., "A101"
    private String examCenter;      // e.g., "Dhaka Center"
    private String applicantID;     // ID of the applicant assigned to this seat
    private String applicantName;

    public SeatPlan(String seatNumber, String examCenter, String applicantID, String applicantName) {
        this.seatNumber = seatNumber;
        this.examCenter = examCenter;
        this.applicantID = applicantID;
        this.applicantName = applicantName;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getExamCenter() {
        return examCenter;
    }

    public void setExamCenter(String examCenter) {
        this.examCenter = examCenter;
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

    @Override
    public String toString() {
        return "SeatPlan{" +
                "seatNumber='" + seatNumber + '\'' +
                ", examCenter='" + examCenter + '\'' +
                ", applicantID='" + applicantID + '\'' +
                ", applicantName='" + applicantName + '\'' +
                '}';
    }
}