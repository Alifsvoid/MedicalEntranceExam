package com.example.medicalentranceexam3.ataul;

public class ExamQuestion {
    private int id;
    private int examId;
    private int questionId;
    private int sequenceNumber;

    public ExamQuestion(int id, int examId, int questionId, int sequenceNumber) {
        this.id = id;
        this.examId = examId;
        this.questionId = questionId;
        this.sequenceNumber = sequenceNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }


    @Override
    public String toString() {
        return "ExamQuestion{" +
                "id=" + id +
                ", examId=" + examId +
                ", questionId=" + questionId +
                ", sequenceNumber=" + sequenceNumber +
                '}';
    }
}
