package com.example.medicalentranceexam3.alif;

import com.example.medicalentranceexam3.utils.BinaryFileHelper;
import com.example.medicalentranceexam3.utils.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class DeleteApplicantViewController
{
    @javafx.fxml.FXML
    private TableColumn<Applicant, String> idCol;
    @javafx.fxml.FXML
    private TableColumn<Applicant, String> nameCol;
    @javafx.fxml.FXML
    private TableColumn<Applicant, LocalDate> dobCol;
    @javafx.fxml.FXML
    private TableView<Applicant> aplicantTableView;
    @javafx.fxml.FXML
    private TableColumn<Applicant, String> emailCol;
    @javafx.fxml.FXML
    private TextField applicantIDTextField;
    @javafx.fxml.FXML
    private TableColumn<Applicant, String> phoneNumCol;
    private ArrayList<Applicant> applicantArrayList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        File file = new File("data/applicants.bin");

        dobCol.setCellValueFactory(new PropertyValueFactory<>("dob"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("applicantID"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        phoneNumCol.setCellValueFactory(new PropertyValueFactory<>("phone"));

        applicantArrayList = BinaryFileHelper.readAllObjects(file);
        aplicantTableView.getItems().addAll(applicantArrayList);
    }

    @javafx.fxml.FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "alif/accountant-dash-view.fxml", "DashBoard");
    }

    @javafx.fxml.FXML
    public void handleDeleteButton(ActionEvent actionEvent) {
        String id = applicantIDTextField.getText().trim();

        if (id.isEmpty()) {
            errorAlertShow("Please enter an applicant ID.");
            return;
        }

        boolean removed = false;

        // Find and remove the target applicant
        for (int i = 0; i < applicantArrayList.size(); i++) {
            if (applicantArrayList.get(i).getApplicantID().equals(id)) {
                applicantArrayList.remove(i);
                removed = true;
                break;
            }
        }

        if (!removed) {
            errorAlertShow("Applicant with ID " + id + " not found.");
            return;
        }

        // Save back to file
        File file = new File("data/applicants.bin");
        BinaryFileHelper.writeAllObjects(file, applicantArrayList);

        // Refresh table
        aplicantTableView.getItems().clear();
        aplicantTableView.getItems().addAll(applicantArrayList);

        // Clear text field
        applicantIDTextField.clear();

        successAlert("Applicant deleted successfully.");
    }

    public void errorAlertShow(String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText(message);
        a.showAndWait();
    }

    public void successAlert(String message) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText(message);
        a.showAndWait();

    }
}