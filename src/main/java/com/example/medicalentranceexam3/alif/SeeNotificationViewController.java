package com.example.medicalentranceexam3.alif;

import com.example.medicalentranceexam3.LoggedInSession;
import com.example.medicalentranceexam3.utils.BinaryFileHelper;
import com.example.medicalentranceexam3.utils.SceneSwitcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SeeNotificationViewController {

    @FXML private TableView<Notification> tableView;
    @FXML private TableColumn<Notification, String> colID;
    @FXML private TableColumn<Notification, String> colMessage;
    @FXML private TableColumn<Notification, LocalDateTime> colTime;

    private static final String FILE_PATH = "data/notifications.bin";

    @FXML
    public void initialize() {
        setupColumns();
        loadNotifications();
    }

    private void setupColumns() {
        colID.setCellValueFactory(new PropertyValueFactory<>("notificationID"));
        colMessage.setCellValueFactory(new PropertyValueFactory<>("message"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("timestamp"));
    }

    private void loadNotifications() {

        String loggedInID = LoggedInSession.getLoggedInApplicant().getApplicantID();

        File file = new File(FILE_PATH);
        ArrayList<Notification> all = BinaryFileHelper.readAllObjects(file);

        ObservableList<Notification> filtered = FXCollections.observableArrayList();

        for (Notification nt : all) {
            if (nt.getApplicantID().equals(loggedInID)) {
                filtered.add(nt);
            }
        }

        tableView.setItems(filtered);
    }

    @FXML
    private void onBackClicked(ActionEvent event) throws IOException {
            SceneSwitcher.sceneSwitch(event, "alif/applicant-dash-view.fxml", "Dashboard");
    }
}