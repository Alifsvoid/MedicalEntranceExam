package com.example.medicalentranceexam3.alif;

import com.example.medicalentranceexam3.LoggedInSession;
import com.example.medicalentranceexam3.utils.BinaryFileHelper;
import com.example.medicalentranceexam3.utils.SceneSwitcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class SeeAdmitCardViewController {

    @FXML private TableView<AdmitCard> tableView;
    @FXML private TableColumn<AdmitCard, String> colCardID;
    @FXML private TableColumn<AdmitCard, String> colExamID;
    @FXML private TableColumn<AdmitCard, String> colName;
    @FXML private TableColumn<AdmitCard, String> colSeat;
    @FXML private TableColumn<AdmitCard, String> colCenter;
    @FXML private TableColumn<AdmitCard, LocalDate> colDate;

    private static final String FILE_PATH = "data/admitCards.bin";

    @FXML
    public void initialize() {
        setupColumns();
        loadAdmitCards();
    }

    private void setupColumns() {
        colCardID.setCellValueFactory(new PropertyValueFactory<>("cardID"));
        colExamID.setCellValueFactory(new PropertyValueFactory<>("examID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("applicantName"));
        colSeat.setCellValueFactory(new PropertyValueFactory<>("seatNumber"));
        colCenter.setCellValueFactory(new PropertyValueFactory<>("examCenter"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("examDate"));
    }

    private void loadAdmitCards() {

        String loggedInID = LoggedInSession.getLoggedInApplicant().getApplicantID();

        File file = new File(FILE_PATH);
        ArrayList<AdmitCard> allCards = BinaryFileHelper.readAllObjects(file);

        ObservableList<AdmitCard> filteredList = FXCollections.observableArrayList();

        for (AdmitCard card : allCards) {
            if (card.getExamID().equals(loggedInID)) {
                filteredList.add(card);
            }
        }

        tableView.setItems(filteredList);
    }

    @FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "alif/applicant-dash-view.fxml", "DashBoard");
    }
}
