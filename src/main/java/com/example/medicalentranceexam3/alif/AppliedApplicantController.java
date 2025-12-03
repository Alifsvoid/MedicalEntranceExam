package com.example.medicalentranceexam3.alif;

import com.example.medicalentranceexam3.utils.BinaryFileHelper;
import com.example.medicalentranceexam3.utils.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class AppliedApplicantController {

    @FXML private TableView<AppliedExam> appliedExamTableView;
    @FXML private TableColumn<AppliedExam, String> applicationIDCol;
    @FXML private TableColumn<AppliedExam, String> applicantIDCol;
    @FXML private TableColumn<AppliedExam, String> applicantNameCol;
    @FXML private TableColumn<AppliedExam, String> examIDCol;
    @FXML private TableColumn<AppliedExam, String> examNameCol;
    @FXML private TableColumn<AppliedExam, String> applicationDateCol;
    @FXML private TableColumn<AppliedExam, String> statusCol;

    @FXML private ComboBox<String> filterStatusComboBox;
    @FXML private TextField applicationIDTextField;
    @FXML private ComboBox<String> statusComboBox;

    private ArrayList<AppliedExam> appliedExamList = new ArrayList<>();
    private final File file = new File("data/appliedApplicants.bin");

    @FXML
    public void initialize() {
        filterStatusComboBox.getItems().addAll("Approved", "Rejected", "Pending");
        statusComboBox.getItems().addAll("Approved", "Rejected", "Pending");

        // Table columns
        applicationIDCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("applicationID"));
        applicantIDCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("applicantID"));
        applicantNameCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("applicantName"));
        examIDCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("examID"));
        examNameCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("examName"));
        applicationDateCol.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(
                        cellData.getValue().getApplicationDate().format(DateTimeFormatter.ISO_DATE)
                )
        );
        statusCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("approved"));

        // Load data from file
        appliedExamList = BinaryFileHelper.readAllObjects(file);
        appliedExamTableView.getItems().addAll(appliedExamList);

    }

    @FXML
    public void handleFilterButton(ActionEvent event) {
        String status = filterStatusComboBox.getValue();
        if (status == null) return;

        ArrayList<AppliedExam> filtered = appliedExamList.stream()
                .filter(a -> a.isApproved().equalsIgnoreCase(status))
                .collect(Collectors.toCollection(ArrayList::new));

        appliedExamTableView.getItems().clear();
        appliedExamTableView.getItems().addAll(filtered);
    }

    @FXML
    public void handleUpdateStatusButton(ActionEvent event) {
        String appID = applicationIDTextField.getText().trim();
        String status = statusComboBox.getValue();

        if (appID.isEmpty() || status == null) {
            showError("Please enter Application ID and select status.");
            return;
        }

        boolean found = false;
        for (AppliedExam a : appliedExamList) {
            if (a.getApplicationID().equals(appID)) {
                a.setApproved(status);
                found = true;
                break;
            }
        }

        if (!found) {
            showError("Application ID not found.");
            return;
        }

        // Save to file
        BinaryFileHelper.writeAllObjects(file, appliedExamList);

        // Refresh table
        appliedExamTableView.getItems().clear();
        appliedExamTableView.getItems().addAll(appliedExamList);

        showSuccess("Status updated successfully.");
        applicationIDTextField.clear();
        statusComboBox.getSelectionModel().clearSelection();
    }

    @FXML
    public void handleBackButton(ActionEvent event) throws IOException {
        SceneSwitcher.sceneSwitch(event, "alif/accountant-dash-view.fxml", "Dashboard");
    }

    private void showError(String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText(msg);
        a.showAndWait();
    }

    private void showSuccess(String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(msg);
        a.showAndWait();
    }
}
