package com.example.medicalentranceexam3.alif;


import com.example.medicalentranceexam3.LoggedInSession;
import com.example.medicalentranceexam3.utils.BinaryFileHelper;
import com.example.medicalentranceexam3.utils.SceneSwitcher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class ApplyExamViewController {

    @FXML
    private TextField examIDField;

    @FXML
    private TextField examNameField;

    private final File FILE_PATH = new File("data/appliedApplicants.bin");

    @FXML
    public void handleApplyButton() {
        String examID = examIDField.getText().trim();
        String examName = examNameField.getText().trim();

        if (examID.isEmpty() || examName.isEmpty()) {
            showAlert("Error", "Please fill all fields.");
            return;
        }

        // Get logged-in applicant
        Applicant applicant = LoggedInSession.getLoggedInApplicant();
        if (applicant == null) {
            showAlert("Error", "No logged-in applicant found.");
            return;
        }

        String applicationID = generateApplicationID();

        AppliedExam appliedExam = new AppliedExam(
                applicationID,
                applicant.getApplicantID(),   // from session
                applicant.getName(),          // from session
                examID,
                examName,
                LocalDate.now()
        );

        // Save to binary file
        saveAppliedExam(appliedExam);

        showAlert("Success", "Your application has been submitted!");
        clearFields();
    }

    private String generateApplicationID() {
        return "APP-" + UUID.randomUUID().toString().substring(0, 8);
    }

    private void saveAppliedExam(AppliedExam exam) {
        ArrayList<AppliedExam> list = BinaryFileHelper.readAllObjects(FILE_PATH);

        if (list == null) list = new ArrayList<>();

        list.add(exam);
        BinaryFileHelper.writeAllObjects(FILE_PATH, list);
    }

    private void clearFields() {
        examIDField.clear();
        examNameField.clear();
    }

    @FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "alif/applicant-dash-view.fxml", "Dashboard");
    }

    private void showAlert(String title, String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.show();
    }
}