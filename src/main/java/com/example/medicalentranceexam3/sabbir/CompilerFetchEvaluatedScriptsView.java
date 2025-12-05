package com.example.medicalentranceexam3.sabbir;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class CompilerFetchEvaluatedScriptsView
{
    @javafx.fxml.FXML
    private TableColumn scriptsPendingCol;
    @javafx.fxml.FXML
    private Button fetchButton;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private Text totalPendingText;
    @javafx.fxml.FXML
    private Button backButton;
    @javafx.fxml.FXML
    private TableView evaluatorsTable;
    @javafx.fxml.FXML
    private TableColumn scriptsSubmittedCol;
    @javafx.fxml.FXML
    private TableColumn evaluatorNameCol;
    @javafx.fxml.FXML
    private Text totalReceivedText;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleBackButton(ActionEvent actionEvent) {
    }
}