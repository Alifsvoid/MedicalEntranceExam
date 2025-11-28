package com.example.medicalentranceexam3.Ataulpkg;

import java.util.ArrayList;

public class Question {
    private int id;
    private String text;
    private ArrayList<Option> options;
    private int correctOptionId;
    private String status;
    private String difficulty;
    private String subject;
    private String rejectReason;


    public Question(int id, String text, ArrayList<Option> options, int correctOptionId, String status, String difficulty, String subject, String rejectReason) {
        this.id = id;
        this.text = text;
        this.options = options;
        this.correctOptionId = correctOptionId;
        this.status = status;
        this.difficulty = difficulty;
        this.subject = subject;
        this.rejectReason = rejectReason;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<Option> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option> options) {
        this.options = options;
    }

    public int getCorrectOptionId() {
        return correctOptionId;
    }

    public void setCorrectOptionId(int correctOptionId) {
        this.correctOptionId = correctOptionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }


    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", options=" + options +
                ", correctOptionId=" + correctOptionId +
                ", status='" + status + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", subject='" + subject + '\'' +
                ", rejectReason='" + rejectReason + '\'' +
                '}';
    }
}

