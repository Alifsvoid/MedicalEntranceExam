package com.example.medicalentranceexam3;

import com.example.medicalentranceexam3.alif.Accountant;
import com.example.medicalentranceexam3.alif.Applicant;
import com.example.medicalentranceexam3.ataul.Director;
import com.example.medicalentranceexam3.ataul.QuestionModerator;
import com.example.medicalentranceexam3.utils.BinaryFileHelper;
import com.example.medicalentranceexam3.utils.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LoginViewController {

    @javafx.fxml.FXML
    private javafx.scene.control.TextField emailTextField;
    @javafx.fxml.FXML
    private javafx.scene.control.PasswordField passTextField;
    @javafx.fxml.FXML
    private javafx.scene.control.ComboBox<String> userTypeComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        userTypeComboBox.getItems().addAll("Accountant", "Applicant", "Question Moderator", "Director");
    }

    @javafx.fxml.FXML
    public void handleLogButton(ActionEvent actionEvent) throws IOException {
        String email = emailTextField.getText().trim();
        String password = passTextField.getText().trim();
        String userType = userTypeComboBox.getValue();

        File fileApplicant = new File("data/applicants.bin");
        File fileAccountant = new File("data/accountants.bin");
        File fileModerator = new File("data/questionModerators.bin");
        File fileDirector = new File("data/directors.bin");


        if (email.isEmpty() || password.isEmpty() || userType == null) {
            showAlert("Error", "Please fill all fields.");
            return;
        }

        switch (userType) {

            case "Accountant":
                List<Accountant> accountants = BinaryFileHelper.readAllObjects(fileAccountant);
                for (Accountant a : accountants) {
                    if (a.getEmail().equals(email) && a.getPassword().equals(password)) {
                        LoggedInSession.setLoggedInAccountant(a);
                        SceneSwitcher.sceneSwitch(actionEvent, "alif/accountant-dash-view.fxml", "Dashboard");
                        return;
                    }
                }
                showAlert("Error", "Invalid Accountant credentials.");
                break;

            case "Applicant":
                List<Applicant> applicants = BinaryFileHelper.readAllObjects(fileApplicant);
                for (Applicant app : applicants) {
                    if (app.getEmail().equals(email) && app.getPassword().equals(password)) {
                        LoggedInSession.setLoggedInApplicant(app);
                        SceneSwitcher.sceneSwitch(actionEvent, "alif/applicant-dash-view.fxml", "Dashboard");
                        return;
                    }
                }
                showAlert("Error", "Invalid Applicant credentials.");
                break;

            case "Question Moderator":
                List<QuestionModerator> moderators = BinaryFileHelper.readAllObjects(fileModerator);
                for (QuestionModerator qm : moderators) {
                    if (qm.getEmail().equals(email) && qm.getPassword().equals(password)) {
                        LoggedInSession.setLoggedInQuestionModerator(qm);
                        SceneSwitcher.sceneSwitch(actionEvent, "ataul/question-modarator-dash-view.fxml", "Dashboard");
                        return;
                    }
                }
                showAlert("Error", "Invalid Question Moderator credentials.");
                break;

            case "Director":
                List<Director> directors = BinaryFileHelper.readAllObjects(fileDirector);
                for (Director d : directors) {
                    if (d.getEmail().equals(email) && d.getPassword().equals(password)) {
                        System.out.println("hello");
                        LoggedInSession.setLoggedInDirector(d);
                        SceneSwitcher.sceneSwitch(actionEvent, "ataul/director-dash-view.fxml", "Dashboard");
                        return;
                    }
                }
                showAlert("Error", "Invalid Director credentials.");
                break;

            default:
                showAlert("Error", "Unknown user type.");
        }
    }


    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
