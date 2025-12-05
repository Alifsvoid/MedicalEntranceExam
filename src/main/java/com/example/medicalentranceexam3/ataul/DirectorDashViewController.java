package com.example.medicalentranceexam3.ataul;

import com.example.medicalentranceexam3.utils.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;

import java.io.IOException;

public class DirectorDashViewController
{
    @javafx.fxml.FXML
    private Text emailText;
    @javafx.fxml.FXML
    private Text nameText;

    @javafx.fxml.FXML
    public void initialize() {
    }


    @Deprecated
    public void handleAddQuestionButton(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.sceneSwitch(actionEvent, "ataul/", "Hello");
    }

    @Deprecated
    public void handleEdicQuestionButton(ActionEvent actionEvent)throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "ataul/", "Hello");
    }

    @javafx.fxml.FXML
    public void handleDeleteSubject(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.sceneSwitch(actionEvent, "ataul/delete-subject-view.fxml", "Hello");
    }

    @javafx.fxml.FXML
    public void handleAddSubject(ActionEvent actionEvent)throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "ataul/add-subject-view.fxml", "Hello");
    }

    @javafx.fxml.FXML
    public void handleAssignSubject(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.sceneSwitch(actionEvent, "ataul/assign-subject-view.fxml", "Hello");
    }

    @javafx.fxml.FXML
    public void handleEditSubjectButton(ActionEvent actionEvent)throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "ataul/edit-subject-view.fxml", "Hello");
    }
}
//        SceneSwitcher.sceneSwitch(actionEvent, "ataul/", "Hello");
