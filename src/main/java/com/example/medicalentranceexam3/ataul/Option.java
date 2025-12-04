package com.example.medicalentranceexam3.ataul;

import java.io.Serializable;

public class Option implements Serializable {
    private int id;
    private String text;

    public Option(int id, String text) {
        this.id = id;
        this.text = text;
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

    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
