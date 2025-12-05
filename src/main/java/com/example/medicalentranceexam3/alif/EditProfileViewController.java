package com.example.medicalentranceexam3.alif;

import com.example.medicalentranceexam3.LoggedInSession;
import com.example.medicalentranceexam3.utils.BinaryFileHelper;
import com.example.medicalentranceexam3.utils.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class EditProfileViewController {

    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private DatePicker dobPicker;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;

    private final File FILE = new File("data/applicants.bin");

    @FXML
    public void initialize() {
        loadApplicant();
    }

    private void loadApplicant() {
        Applicant applicant = LoggedInSession.getLoggedInApplicant();

        if (applicant == null) {
            showAlert("Error", "No logged-in applicant found!");
            return;
        }

        idField.setText(applicant.getApplicantID());
        nameField.setText(applicant.getName());
        dobPicker.setValue(applicant.getDob());
        phoneField.setText(applicant.getPhone());
        emailField.setText(applicant.getEmail());
        passwordField.setText(applicant.getPassword());
    }

    @FXML
    private void onSave() {
        List<Object> allApplicants = BinaryFileHelper.readAllObjects(FILE);

        Applicant logged = LoggedInSession.getLoggedInApplicant();

        for (Object obj : allApplicants) {
            if (obj instanceof Applicant) {
                Applicant a = (Applicant) obj;

                if (a.getApplicantID().equals(logged.getApplicantID())) {

                    a.setName(nameField.getText());
                    a.setDob(dobPicker.getValue());
                    a.setPhone(phoneField.getText());
                    a.setEmail(emailField.getText());
                    a.setPassword(passwordField.getText());

                    // Update session
                    LoggedInSession.setLoggedInApplicant(a);

                    break;
                }
            }
        }

        BinaryFileHelper.writeAllObjects(FILE, allApplicants);

        showAlert("Success", "Profile updated successfully!");
    }

    @FXML
    private void onCancel(ActionEvent actionEvent) {
//        SceneSwitcher.switchTo("ApplicantProfileView.fxml");
    }

    @FXML
    private void onBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "alif/applicant-dash-view.fxml", "Dashboard");
    }



    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.show();
    }
}
