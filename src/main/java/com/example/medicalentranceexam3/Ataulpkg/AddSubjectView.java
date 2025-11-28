package com.example.medicalentranceexam3.Ataulpkg;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AddSubjectView
{
    @javafx.fxml.FXML
    private TextField codeTextField;
    @javafx.fxml.FXML
    private TextField subjectTextField;
    @javafx.fxml.FXML
    private TableColumn<Subject, String> codeCol;
    @javafx.fxml.FXML
    private TableColumn<Subject, Integer> idCol;
    @javafx.fxml.FXML
    private TableView<Subject> subjectTableView;
    @javafx.fxml.FXML
    private TableColumn<Subject, String> subjectCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleAddSubjectButton(ActionEvent actionEvent) {
    }
}