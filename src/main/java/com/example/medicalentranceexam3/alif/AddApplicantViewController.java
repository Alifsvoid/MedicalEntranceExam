package com.example.medicalentranceexam3.alif;

import com.example.medicalentranceexam3.utils.BinaryFileHelper;
import com.example.medicalentranceexam3.utils.SceneSwitcher;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class AddApplicantViewController
{
    @javafx.fxml.FXML
    private TextField phoneTextField;
    @javafx.fxml.FXML
    private TableColumn<Applicant, String> idCol;
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private TableColumn<Applicant, String> nameCol;
    @javafx.fxml.FXML
    private TableColumn<Applicant, LocalDate> dobCol;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TableView<Applicant> aplicantTableView;
    @javafx.fxml.FXML
    private TableColumn<Applicant, String> emailCol;
    @javafx.fxml.FXML
    private TextField applicantIDTextField;
    @javafx.fxml.FXML
    private DatePicker dobDatePicker;
    @javafx.fxml.FXML
    private TableColumn<Applicant, String> phoneNumCol;
    private ArrayList<Applicant> applicantArrayList = new ArrayList<>();
    @javafx.fxml.FXML
    private PasswordField passwordTextField;

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
    public void handleAddApplicantButton(ActionEvent actionEvent) {
        Applicant applicant = new Applicant(
                applicantIDTextField.getText(),
                nameTextField.getText(),
                dobDatePicker.getValue(),
                phoneTextField.getText(),
                emailTextField.getText(),
                passwordTextField.getText()
        );

        File file = new File("data/applicants.bin");
        applicantArrayList.add(applicant);
        BinaryFileHelper.writeAllObjects(file, applicantArrayList);
        aplicantTableView.getItems().clear();
        aplicantTableView.getItems().addAll(applicantArrayList);
    }
}