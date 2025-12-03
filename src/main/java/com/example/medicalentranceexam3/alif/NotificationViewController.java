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

public class NotificationViewController {

    @FXML private TextField notificationIDTextField;
    @FXML private TextField applicantIDTextField;
    @FXML private TextArea messageTextArea;

    @FXML private TableView<Notification> notificationTableView;
    @FXML private TableColumn<Notification, String> notificationIDCol;
    @FXML private TableColumn<Notification, String> applicantIDCol;
    @FXML private TableColumn<Notification, String> messageCol;
    @FXML private TableColumn<Notification, String> timestampCol;

    private ArrayList<Notification> notificationList = new ArrayList<>();

    private final File file = new File("data/notifications.bin");

    @FXML
    public void initialize() {
        // Table column bindings
        notificationIDCol.setCellValueFactory(new PropertyValueFactory<>("notificationID"));
        applicantIDCol.setCellValueFactory(new PropertyValueFactory<>("applicantID"));
        messageCol.setCellValueFactory(new PropertyValueFactory<>("message"));
        timestampCol.setCellValueFactory(new PropertyValueFactory<>("timestamp"));

        // Load existing notifications
        notificationList = BinaryFileHelper.readAllObjects(file);
        notificationTableView.getItems().addAll(notificationList);
    }

    @FXML
    public void handleAddNotificationButton(ActionEvent event) {
        String notifID = notificationIDTextField.getText().trim();
        String applicantID = applicantIDTextField.getText().trim();
        String message = messageTextArea.getText().trim();

        if (notifID.isEmpty() || applicantID.isEmpty() || message.isEmpty()) {
            showError("Please fill all fields.");
            return;
        }

        Notification notif = new Notification(notifID, applicantID, message);
        notificationList.add(notif);

        // Save to file
        BinaryFileHelper.writeAllObjects(file, notificationList);

        // Refresh table
        notificationTableView.getItems().clear();
        notificationTableView.getItems().addAll(notificationList);

        clearFields();
        showSuccess("Notification Sent successfully.");
    }

    @FXML
    public void handleBackButton(ActionEvent event) throws IOException {
        SceneSwitcher.sceneSwitch(event, "alif/accountant-dash-view.fxml", "Dashboard");
    }

    private void clearFields() {
        notificationIDTextField.clear();
        applicantIDTextField.clear();
        messageTextArea.clear();
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
