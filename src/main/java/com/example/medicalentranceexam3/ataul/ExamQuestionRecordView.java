package com.example.medicalentranceexam3.ataul;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ExamQuestionRecordView {
    @javafx.fxml.FXML
    private TableView<ExamQuestion> examQuestionTableView;
    @javafx.fxml.FXML
    private TableColumn<ExamQuestion, Integer> sequenceNumCol;
    @javafx.fxml.FXML
    private TableColumn<ExamQuestion, Integer> questionIdCol;
    @javafx.fxml.FXML
    private TableColumn<ExamQuestion, Integer> examIdCol;
    @javafx.fxml.FXML
    private TextField questionIdTextField;
    @javafx.fxml.FXML
    private ComboBox<Integer> seqNumComboBox;
    @javafx.fxml.FXML
    private TextField examIdTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleAssignButton(ActionEvent actionEvent) {
    }
}