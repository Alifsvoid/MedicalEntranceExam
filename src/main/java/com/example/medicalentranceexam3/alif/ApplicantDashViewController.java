package com.example.medicalentranceexam3.alif;

import com.example.medicalentranceexam3.LoggedInSession;
import com.example.medicalentranceexam3.utils.SceneSwitcher;
import javafx.event.ActionEvent;

import java.io.IOException;

public class ApplicantDashViewController
{
    @javafx.fxml.FXML
    public void initialize() {
    }



    @javafx.fxml.FXML
    public void handleLogOutButton(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.sceneSwitch(actionEvent, "login-view.fxml", "Log in");
        LoggedInSession.setLoggedInApplicant(null);
    }

    @javafx.fxml.FXML
    public void handleUpcomingExamButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "alif/upcoming-exam-view.fxml", "Upcoming Exams");
    }

    @javafx.fxml.FXML
    public void handleApplyForExamButton(ActionEvent actionEvent) throws IOException {
        //
        SceneSwitcher.sceneSwitch(actionEvent, "alif/apply-exam-view.fxml", "Apply for Exam");
    }

    @javafx.fxml.FXML
    public void handleEditProfileButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "alif/edit-profile-view.fxml", "Apply for Exam");

    }

    @javafx.fxml.FXML
    public void handleSubmitFeedbackButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleNotificationButton(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.sceneSwitch(actionEvent, "alif/see-notification-view.fxml", "Notifications");
    }

    @javafx.fxml.FXML
    public void handleProfileButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "alif/applicant-profile-view.fxml", "Apply for Exam");

    }

    @javafx.fxml.FXML
    public void handleAdmitCardButton(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.sceneSwitch(actionEvent, "alif/see-admit-card-view.fxml", "Admit Cards");

    }

    @javafx.fxml.FXML
    public void handleEditChosenSubButton(ActionEvent actionEvent) {
    }
}