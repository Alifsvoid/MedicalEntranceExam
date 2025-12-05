package com.example.medicalentranceexam3.ataul;


import com.example.medicalentranceexam3.utils.BinaryFileHelper;
import com.example.medicalentranceexam3.utils.SceneSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class EditQuestionView {

    @FXML private TextField questionIdTextField;
    @FXML private TextField questionTextField;

    @FXML private TextField op1TextField;
    @FXML private TextField op2TextField;
    @FXML private TextField op3TextField;
    @FXML private TextField op4TextField;

    @FXML private ComboBox<Integer> answerComboBox;

    private final File QUESTION_FILE = new File("data/questions.bin");
    private ArrayList<Question> questionList = new ArrayList<>();

    private Question targetQuestion = null;

    @FXML
    public void initialize() {
        // Load answer numbers
        answerComboBox.getItems().addAll(1, 2, 3, 4);

        // Load all questions
        questionList = BinaryFileHelper.readAllObjects(QUESTION_FILE);

        // Auto-fill when user types ID and presses Enter
        questionIdTextField.setOnAction(e -> loadQuestion());
    }

    private void loadQuestion() {
        try {
            int qId = Integer.parseInt(questionIdTextField.getText().trim());

            targetQuestion = null;
            for (Question q : questionList) {
                if (q.getId() == qId) {
                    targetQuestion = q;
                    break;
                }
            }

            if (targetQuestion == null) {
                showError("No question found with this ID.");
                clearFields();
                return;
            }

            // Fill UI fields
            questionTextField.setText(targetQuestion.getText());

            if (targetQuestion.getOptions() != null && targetQuestion.getOptions().size() == 4) {
                op1TextField.setText(targetQuestion.getOptions().get(0).getText());
                op2TextField.setText(targetQuestion.getOptions().get(1).getText());
                op3TextField.setText(targetQuestion.getOptions().get(2).getText());
                op4TextField.setText(targetQuestion.getOptions().get(3).getText());
            }

            answerComboBox.setValue(targetQuestion.getCorrectOptionId());

        } catch (NumberFormatException e) {
            showError("Invalid Question ID.");
        }
    }

    @FXML
    public void handleUpdateButton(ActionEvent event) {

        if (targetQuestion == null) {
            showError("Please load a question first.");
            return;
        }

        try {
            String qText = questionTextField.getText().trim();
            String o1 = op1TextField.getText().trim();
            String o2 = op2TextField.getText().trim();
            String o3 = op3TextField.getText().trim();
            String o4 = op4TextField.getText().trim();
            Integer correct = answerComboBox.getValue();

            if (qText.isEmpty() || o1.isEmpty() || o2.isEmpty() || o3.isEmpty() || o4.isEmpty()) {
                showError("All fields must be filled.");
                return;
            }

            if (correct == null) {
                showError("Please select a correct answer.");
                return;
            }

            // Update question
            targetQuestion.setText(qText);

            ArrayList<Option> ops = new ArrayList<>();
            ops.add(new Option(1, o1));
            ops.add(new Option(2, o2));
            ops.add(new Option(3, o3));
            ops.add(new Option(4, o4));

            targetQuestion.setOptions(ops);
            targetQuestion.setCorrectOptionId(correct);

            // Save all questions
            BinaryFileHelper.writeAllObjects(QUESTION_FILE, questionList);

            showSuccess("Question updated successfully.");
            clearFields();

        } catch (Exception e) {
            e.printStackTrace();
            showError("Something went wrong.");
        }
    }

    private void clearFields() {
        questionTextField.clear();
        op1TextField.clear();
        op2TextField.clear();
        op3TextField.clear();
        op4TextField.clear();
        answerComboBox.getSelectionModel().clearSelection();
        targetQuestion = null;
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