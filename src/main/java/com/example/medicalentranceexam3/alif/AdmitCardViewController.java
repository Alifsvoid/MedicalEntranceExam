package com.example.medicalentranceexam3.alif;

import com.example.medicalentranceexam3.utils.BinaryFileHelper;
import com.example.medicalentranceexam3.utils.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class AdmitCardViewController
{
    @javafx.fxml.FXML
    private TableColumn<AdmitCard, String> seatNumCol;
    @javafx.fxml.FXML
    private TableColumn<AdmitCard, String> examIDCol;
    @javafx.fxml.FXML
    private TableView<AdmitCard> aplicantTableView;
    @javafx.fxml.FXML
    private TextField examCenter;
    @javafx.fxml.FXML
    private TextField applicantName;
    @javafx.fxml.FXML
    private TableColumn<AdmitCard, String> cardIDCol;
    @javafx.fxml.FXML
    private TextField seatNumber;
    @javafx.fxml.FXML
    private TableColumn<AdmitCard, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TextField cardID;
    @javafx.fxml.FXML
    private TableColumn<AdmitCard, String> nameCol;
    @javafx.fxml.FXML
    private TextField examID;
    @javafx.fxml.FXML
    private DatePicker examDatePicker;
    @javafx.fxml.FXML
    private TableColumn<AdmitCard, String> centerCol;
    private ArrayList<AdmitCard> admitCardArrayList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        File file = new File("data/admitCards.bin");

        cardIDCol.setCellValueFactory(new PropertyValueFactory<>("cardID"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("applicantName"));
        centerCol.setCellValueFactory(new PropertyValueFactory<>("examCenter"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("examDate"));
        examIDCol.setCellValueFactory(new PropertyValueFactory<>("examID"));
        seatNumCol.setCellValueFactory(new PropertyValueFactory<>("seatNumber"));

        admitCardArrayList = BinaryFileHelper.readAllObjects(file);
        aplicantTableView.getItems().addAll(admitCardArrayList);
    }

    @javafx.fxml.FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "alif/accountant-dash-view.fxml", "DashBoard");
    }

    @javafx.fxml.FXML
    public void handleGenerateButton(ActionEvent actionEvent) {
        // Validate input fields
        if (cardID.getText().isEmpty() ||
                applicantName.getText().isEmpty() ||
                examCenter.getText().isEmpty() ||
                examID.getText().isEmpty() ||
                seatNumber.getText().isEmpty() ||
                examDatePicker.getValue() == null) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Missing Information");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all fields before generating the admit card.");
            alert.showAndWait();
            return;
        }

        // Read input values
        String newCardID = cardID.getText().trim();
        String newApplicantName = applicantName.getText().trim();
        String newExamCenter = examCenter.getText().trim();
        LocalDate newExamDate = examDatePicker.getValue();
        String newExamID = examID.getText().trim();
        String newSeatNumber = seatNumber.getText().trim();

        // Create the AdmitCard object
        AdmitCard newCard = new AdmitCard(
                newCardID,
                newExamID,
                newApplicantName,
                newSeatNumber,
                newExamCenter,
                newExamDate
        );

        // Add to array list
        admitCardArrayList.add(newCard);

        // Add to table
        aplicantTableView.getItems().add(newCard);

        // Save to file
        File file = new File("data/admitCards.bin");
        BinaryFileHelper.writeAllObjects(file, admitCardArrayList);

        // Success alert
        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("Success");
        successAlert.setHeaderText(null);
        successAlert.setContentText("Admit Card generated successfully!");
        successAlert.showAndWait();

        // Clear input fields
        cardID.clear();
        applicantName.clear();
        examCenter.clear();
        examID.clear();
        seatNumber.clear();
        examDatePicker.setValue(null);
    }
}