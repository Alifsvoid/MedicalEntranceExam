package com.example.medicalentranceexam3.alif;

import java.io.Serializable;
import java.time.LocalDate;

public class AdmitCard implements Serializable {
    private String cardID;
    private String examID;// link to the applicant
    private String applicantName;
    private String seatNumber;
    private String examCenter;   // optional
    private LocalDate examDate;

    public AdmitCard(String cardID, String examID, String applicantName, String seatNumber, String examCenter, LocalDate examDate) {
        this.cardID = cardID;
        this.examID = examID;
        this.applicantName = applicantName;
        this.seatNumber = seatNumber;
        this.examCenter = examCenter;
        this.examDate = examDate;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }


    public String getExamID() {
        return examID;
    }

    public void setExamID(String examID) {
        this.examID = examID;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
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

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }


    @Override
    public String toString() {
        return "AdmitCard{" +
                "cardID='" + cardID + '\'' +
                ", examID='" + examID + '\'' +
                ", applicantName='" + applicantName + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                ", examCenter='" + examCenter + '\'' +
                ", examDate=" + examDate +
                '}';
    }
}