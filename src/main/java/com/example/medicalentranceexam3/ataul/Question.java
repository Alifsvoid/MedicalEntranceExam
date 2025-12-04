package com.example.medicalentranceexam3.ataul;

import java.io.Serializable;
import java.util.ArrayList;

public class Question implements Serializable {
    private int id;
    private String text;
    private ArrayList<Option> options;
    private int correctOptionId;
    private String status;
    private String difficulty;
    private Subject subject;
    private int examID;


    public Question(int id, String text, String status, String difficulty, Subject subject, int examID) {
        this.id = id;
        this.text = text;
        this.status = status;
        this.difficulty = difficulty;
        this.subject = subject;
        this.examID = examID;
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getExamID() {
        return examID;
    }

    public void setExamID(int examID) {
        this.examID = examID;
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
                '}';
    }
}

