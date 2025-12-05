package com.example.medicalentranceexam3.ataul;

import com.example.medicalentranceexam3.utils.BinaryFileHelper;
import com.example.medicalentranceexam3.utils.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DeleteQuestionView {

    @FXML
    private TextField questionIdTextField;

    private final File QUESTION_FILE = new File("data/questions.bin");
    private ArrayList<Question> questionList = new ArrayList<>();

    @FXML
    public void initialize() {
        // Load all questions
        questionList = BinaryFileHelper.readAllObjects(QUESTION_FILE);
    }

    @FXML
    public void handleDeleteButton() {

        try {
            int qId = Integer.parseInt(questionIdTextField.getText().trim());

            // Find target question
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

            // Remove from list
            questionList.remove(target);

            // Save file
            BinaryFileHelper.writeAllObjects(QUESTION_FILE, questionList);

            showSuccess("Question deleted successfully.");

            questionIdTextField.clear();

        } catch (NumberFormatException e) {
            showError("Invalid Question ID.");
        } catch (Exception e) {
            e.printStackTrace();
            showError("Something went wrong.");
        }
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
    public void handleBackButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "ataul/question-modarator-dash-view.fxml", "Dashboard");
    }
}