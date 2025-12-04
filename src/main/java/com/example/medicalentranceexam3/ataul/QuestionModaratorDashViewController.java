package com.example.medicalentranceexam3.ataul;

import com.example.medicalentranceexam3.LoggedInSession;
import com.example.medicalentranceexam3.utils.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;

import java.io.IOException;

public class QuestionModaratorDashViewController {
    @javafx.fxml.FXML
    private Text emailText;
    @javafx.fxml.FXML
    private Text nameText;

    @javafx.fxml.FXML
    public void initialize() {
        QuestionModerator qm = LoggedInSession.getLoggedInQuestionModerator();
        nameText.setText(qm.getName());
        emailText.setText(qm.getEmail());
    }

    @javafx.fxml.FXML
    public void handleSetStatusButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleAssignedExamButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleAddQuestionButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "ataul/add-question-view.fxml", "Add Question");
    }

    @javafx.fxml.FXML
    public void handleEdicQuestionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleAddOptionsButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "ataul/add-options-view.fxml", "Add Options");

    }

    @javafx.fxml.FXML
    public void handleDeleteQuestionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleAddSubjectButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "ataul/add-subject-view.fxml", "Add Subject");

    }
}