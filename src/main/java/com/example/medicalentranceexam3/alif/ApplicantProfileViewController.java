package com.example.medicalentranceexam3.alif;

import com.example.medicalentranceexam3.LoggedInSession;
import com.example.medicalentranceexam3.utils.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ApplicantProfileViewController {

    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField dobField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField feeField;
    @FXML
    private Button refreshButton;

    @FXML
    public void initialize() {
        loadProfile();
    }

    private void loadProfile() {
        Applicant applicant = LoggedInSession.getLoggedInApplicant();

        if (applicant == null) {
            System.out.println("No logged-in applicant found!");
            return;
        }

        idField.setText(applicant.getApplicantID());
        nameField.setText(applicant.getName());
        dobField.setText(String.valueOf(applicant.getDob()));
        phoneField.setText(applicant.getPhone());
        emailField.setText(applicant.getEmail());
        feeField.setText(applicant.getFeePaid());
    }

    @FXML
    private void onRefresh() {
        loadProfile();
    }

    @FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "alif/applicant-dash-view.fxml", "Dashboard");
    }
}