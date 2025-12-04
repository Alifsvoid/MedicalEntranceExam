package com.example.medicalentranceexam3.ataul;

import com.example.medicalentranceexam3.utils.BinaryFileHelper;
import com.example.medicalentranceexam3.utils.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AddOptionsViewController {

    @FXML private TextField questionID;
    @FXML private TextField op1TextField;
    @FXML private TextField op2TextField;
    @FXML private TextField op3TextField;
    @FXML private TextField op4TextField;
    @FXML private ComboBox<Integer> answerComboBox;

    private final File QUESTION_FILE = new File("data/questions.bin");
    private ArrayList<Question> questionList = new ArrayList<>();

    @FXML
    public void initialize() {
        // Load answer list
        answerComboBox.getItems().addAll(1, 2, 3, 4);

        // Load all questions
        questionList = BinaryFileHelper.readAllObjects(QUESTION_FILE);
    }

    @FXML
    public void handleAddButton(ActionEvent event) {

        try {
            int qId = Integer.parseInt(questionID.getText().trim());
            Integer correct = answerComboBox.getValue();

            // Simple validation
            if (correct == null) {
                showError("Please select correct option number.");
                return;
            }

            String o1 = op1TextField.getText().trim();
            String o2 = op2TextField.getText().trim();
            String o3 = op3TextField.getText().trim();
            String o4 = op4TextField.getText().trim();

            if (o1.isEmpty() || o2.isEmpty() || o3.isEmpty() || o4.isEmpty()) {
                showError("All option fields must be filled.");
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

            // Create new option list
            ArrayList<Option> ops = new ArrayList<>();
            ops.add(new Option(1, o1));
            ops.add(new Option(2, o2));
            ops.add(new Option(3, o3));
            ops.add(new Option(4, o4));

            target.setOptions(ops);
            target.setCorrectOptionId(correct);

            // Save to file
            BinaryFileHelper.writeAllObjects(QUESTION_FILE, questionList);

            showSuccess("Options added successfully.");

            clearFields();

        } catch (NumberFormatException e) {
            showError("Invalid Question ID.");
        } catch (Exception e) {
            e.printStackTrace();
            showError("Something went wrong.");
        }
    }

    private void clearFields() {
        questionID.clear();
        op1TextField.clear();
        op2TextField.clear();
        op3TextField.clear();
        op4TextField.clear();
        answerComboBox.getSelectionModel().clearSelection();
    }

    // Same style as AppliedApplicantController
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
