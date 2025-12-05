package com.example.medicalentranceexam3.ataul;

import com.example.medicalentranceexam3.utils.BinaryFileHelper;
import com.example.medicalentranceexam3.utils.SceneSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SetQuestionStatusView {

    @FXML private TextField questionIdTextField;
    @FXML private ComboBox<String> statusComboBox;

    private final File QUESTION_FILE = new File("data/questions.bin");
    private ArrayList<Question> questionList = new ArrayList<>();

    @FXML
    public void initialize() {
        // Load all questions
        questionList = BinaryFileHelper.readAllObjects(QUESTION_FILE);

        // Add example statuses (you can add/edit these as needed)
        statusComboBox.getItems().addAll("Active", "Inactive", "Pending", "Disabled", "Approved");
    }

    @FXML
    public void handleSetButton(ActionEvent event) {
        try {
            // Validate ID
            int qId = Integer.parseInt(questionIdTextField.getText().trim());

            // Validate status
            String newStatus = statusComboBox.getValue();
            if (newStatus == null) {
                showError("Please select a status.");
                return;
            }

            // Find question
            Question target = null;
            for (Question q : questionList) {
                if (q.getId() == qId) {
                    target = q;
                    break;
                }
            }

            if (target == null) {
                showError("No question found with this ID.");
                return;
            }

            // Update
            target.setStatus(newStatus);

            // Save
            BinaryFileHelper.writeAllObjects(QUESTION_FILE, questionList);

            showSuccess("Status updated successfully.");
            clearFields();

        } catch (NumberFormatException e) {
            showError("Invalid Question ID.");
        } catch (Exception e) {
            e.printStackTrace();
            showError("Something went wrong.");
        }
    }

    private void clearFields() {
        questionIdTextField.clear();
        statusComboBox.getSelectionModel().clearSelection();
    }

    private void showError(String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }

    private void showSuccess(String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }

    @FXML
    public void handleBackButton(ActionEvent event) throws IOException {
        SceneSwitcher.sceneSwitch(event, "ataul/question-modarator-dash-view.fxml", "Dashboard");
    }
}