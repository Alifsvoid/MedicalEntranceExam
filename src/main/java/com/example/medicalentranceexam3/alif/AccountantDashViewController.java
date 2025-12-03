package com.example.medicalentranceexam3.alif;

import com.example.medicalentranceexam3.utils.SceneSwitcher;
import javafx.event.ActionEvent;

import java.io.IOException;

public class AccountantDashViewController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleAddApplicantButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "alif/add-applicant-view.fxml", "Add Applicant");
    }

    @javafx.fxml.FXML
    public void handleLogOutButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleEditApplicantButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "alif/edit-applicant-view.fxml", "Update Applicant");
    }

    @javafx.fxml.FXML
    public void handleDeleteApplicant(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "alif/delete-applicant-view.fxml", "Delete Applicant");
    }

    @javafx.fxml.FXML
    public void handleUpdatePaymentButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "alif/payment-status-view.fxml", "Update Payment Status");
    }

    @javafx.fxml.FXML
    public void handleGenerateAdmitButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "alif/admit-card-view.fxml", "Admit Card");
    }

    @javafx.fxml.FXML
    public void handleSeatPlanButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "alif/seat-plan-view.fxml", "Admit Card");
    }

    @javafx.fxml.FXML
    public void handleNotificaitonButton(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.sceneSwitch(actionEvent, "alif/notification-view.fxml", "Admit Card");
    }

    @javafx.fxml.FXML
    public void handleAppliedApplicantButton(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.sceneSwitch(actionEvent, "alif/applied-applicant-view.fxml", "Admit Card");
    }
}