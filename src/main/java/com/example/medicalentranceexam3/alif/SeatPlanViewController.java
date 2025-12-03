package com.example.medicalentranceexam3.alif;

import com.example.medicalentranceexam3.utils.BinaryFileHelper;
import com.example.medicalentranceexam3.utils.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SeatPlanViewController {

    @FXML private TextField seatNumberTextField;
    @FXML private TextField examCenterTextField;
    @FXML private TextField applicantIDTextField;
    @FXML private TextField applicantNameTextField;

    @FXML private TableView<SeatPlan> seatPlanTableView;
    @FXML private TableColumn<SeatPlan, String> seatNumberCol;
    @FXML private TableColumn<SeatPlan, String> examCenterCol;
    @FXML private TableColumn<SeatPlan, String> applicantIDCol;
    @FXML private TableColumn<SeatPlan, String> applicantNameCol;

    private ArrayList<SeatPlan> seatPlanList = new ArrayList<>();

    @FXML
    public void initialize() {
        File file = new File("data/seatplan.bin");

        seatNumberCol.setCellValueFactory(new PropertyValueFactory<>("seatNumber"));
        examCenterCol.setCellValueFactory(new PropertyValueFactory<>("examCenter"));
        applicantIDCol.setCellValueFactory(new PropertyValueFactory<>("applicantID"));
        applicantNameCol.setCellValueFactory(new PropertyValueFactory<>("applicantName"));

        seatPlanList = BinaryFileHelper.readAllObjects(file);
        seatPlanTableView.getItems().addAll(seatPlanList);
    }

    @FXML
    public void handleAddSeatPlanButton(ActionEvent event) {
        String seatNo = seatNumberTextField.getText().trim();
        String center = examCenterTextField.getText().trim();
        String id = applicantIDTextField.getText().trim();
        String name = applicantNameTextField.getText().trim();

        if (seatNo.isEmpty() || center.isEmpty() || id.isEmpty() || name.isEmpty()) {
            showError("Please fill all fields.");
            return;
        }

        SeatPlan sp = new SeatPlan(seatNo, center, id, name);
        seatPlanList.add(sp);

        File file = new File("data/seatplan.bin");
        BinaryFileHelper.writeAllObjects(file, seatPlanList);

        seatPlanTableView.getItems().clear();
        seatPlanTableView.getItems().addAll(seatPlanList);

        clearFields();
        showSuccess("Seat plan added successfully.");
    }

    @FXML
    public void handleBackButton(ActionEvent event) throws IOException {
        SceneSwitcher.sceneSwitch(event, "alif/accountant-dash-view.fxml", "Dashboard");
    }

    private void clearFields() {
        seatNumberTextField.clear();
        examCenterTextField.clear();
        applicantIDTextField.clear();
        applicantNameTextField.clear();
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
