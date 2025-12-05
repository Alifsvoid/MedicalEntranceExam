package com.example.medicalentranceexam3.sabbir;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
public class ModifyMarksView
{
    @javafx.fxml.FXML
    private TextField candidateIdField;
    @javafx.fxml.FXML
    private Button submitButton;
    @javafx.fxml.FXML
    private TableColumn questionCol;
    @javafx.fxml.FXML
    private TableView marksTable;
    @javafx.fxml.FXML
    private Button backButton;
    @javafx.fxml.FXML
    private TableColumn previousMarksCol;
    @javafx.fxml.FXML
    private TextArea notesField;
    @javafx.fxml.FXML
    private TableColumn updatedMarksCol;
    @javafx.fxml.FXML
    private Button saveButton;
    @javafx.fxml.FXML
    private TextField candidateNameField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleBackButton(ActionEvent actionEvent) {
    }
}