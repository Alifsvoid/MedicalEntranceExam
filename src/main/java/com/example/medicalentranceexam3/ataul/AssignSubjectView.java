package com.example.medicalentranceexam3.ataul;

import com.example.medicalentranceexam3.utils.BinaryFileHelper;
import com.example.medicalentranceexam3.utils.SceneSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AssignSubjectView {

    @FXML private TextField questionIdTextField;
    @FXML private TextField subjectID;

    private final File QUESTION_FILE = new File("data/questions.bin");
    private final File SUBJECT_FILE = new File("data/subjects.bin");

    private ArrayList<Question> questionList = new ArrayList<>();
    private ArrayList<Subject> subjectList = new ArrayList<>();

    @FXML
    public void initialize() {
        questionList = BinaryFileHelper.readAllObjects(QUESTION_FILE);
        subjectList  = BinaryFileHelper.readAllObjects(SUBJECT_FILE);
    }

    @FXML
    public void handleAssigneSubjectButton(ActionEvent event) {

        try {
            int qId = Integer.parseInt(questionIdTextField.getText().trim());
            int sId = Integer.parseInt(subjectID.getText().trim());

            // Find question
            Question targetQ = null;
            for (Question q : questionList) {
                if (q.getId() == qId) {
                    targetQ = q;
                    break;
                }
            }

            if (targetQ == null) {
                showError("No question found with this ID.");
                return;
            }

            // Find subject
            Subject targetS = null;
            for (Subject s : subjectList) {
                if (s.getId() == sId) {
                    targetS = s;
                    break;
                }
            }

            if (targetS == null) {
                showError("No subject found with this ID.");
                return;
            }

            // Assign subject
            targetQ.setSubject(targetS);

            // Save back
            BinaryFileHelper.writeAllObjects(QUESTION_FILE, questionList);

            showSuccess("Subject assigned successfully!");
            clearFields();

        } catch (NumberFormatException e) {
            showError("Invalid input. IDs must be numbers.");
        } catch (Exception e) {
            e.printStackTrace();
            showError("Something went wrong.");
        }
    }

    private void clearFields() {
        questionIdTextField.clear();
        subjectID.clear();
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
    public void handBackButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "ataul/director-dash-view.fxml", "Dashboard");
    }
}