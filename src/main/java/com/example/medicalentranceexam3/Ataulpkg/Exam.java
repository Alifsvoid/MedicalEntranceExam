package com.example.medicalentranceexam3.Ataulpkg;

import java.time.LocalDate;

public class Exam {
    private int id;
    private String title;          // "Medical Admission Test 2025"
    private String status;         // Draft, Approved, Published
    private LocalDate publishDate;

    public Exam(int id, String title, String status, LocalDate publishDate) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.publishDate = publishDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }


    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }
}
