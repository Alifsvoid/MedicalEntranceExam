package com.example.medicalentranceexam3.ataul;

import com.example.medicalentranceexam3.LoggedInSession;
import com.example.medicalentranceexam3.utils.BinaryFileHelper;
import com.example.medicalentranceexam3.utils.SceneSwitcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AddQuestionView {

    // FXML fields
    @FXML private TextField questionID;
    @FXML private TextField questionTextField;
    @FXML private ComboBox<String> subjectComboBox;
    @FXML private ComboBox<String> diffLevelComboBox;

    @FXML private TextField questionIdTextField;

    @FXML private TableView<Question> QuestionTableView;
    @FXML private TableColumn<Question, Integer> questionIdCol;
    @FXML private TableColumn<Question, String> questionCol;
    @FXML private TableColumn<Question, String> subCol;

    @FXML private TableView<Option> optionsTableView;
    @FXML private TableColumn<Option, Integer> optionIdCol;
    @FXML private TableColumn<Option, String> optionsCol;

    // File paths
    private final File QUESTION_FILE = new File("data/questions.bin");
    private final File SUBJECT_FILE = new File("data/subjects.bin");

    private ArrayList<Question> questionList = new ArrayList<>();
    private ArrayList<Option> optionList = new ArrayList<>();

    @FXML
    public void initialize() {

        // Load subjects into the ComboBox
        ArrayList<Subject> subjects = BinaryFileHelper.readAllObjects(SUBJECT_FILE);
        for (Subject s: subjects){
            subjectComboBox.getItems().add(s.getName());
        }

        // Difficulty levels
        diffLevelComboBox.getItems().addAll("Easy", "Medium", "Hard");

        // Setup Question table
        questionIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        questionCol.setCellValueFactory(new PropertyValueFactory<>("text"));
        subCol.setCellValueFactory(new PropertyValueFactory<>("difficulty"));

        // Setup Options table
        optionIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        optionsCol.setCellValueFactory(new PropertyValueFactory<>("text"));

        questionList = BinaryFileHelper.readAllObjects(QUESTION_FILE);
        QuestionTableView.getItems().addAll(questionList);
    }

    // ---------------- LOAD QUESTIONS ----------------
    private void loadQuestions() {
        questionList.clear();
        ArrayList<Question> list = BinaryFileHelper.readAllObjects(QUESTION_FILE);
        questionList.addAll(list);
    }

    // ---------------- ADD QUESTION ----------------
    @FXML
    public void handleCreateButton(ActionEvent actionEvent) {

        try {
            int qId = Integer.parseInt(questionID.getText());
            String qText = questionTextField.getText();
            String subject = subjectComboBox.getValue();
            String difficulty = diffLevelComboBox.getValue();

            if (qText.isEmpty() || subject == null || difficulty == null) {
                alert("Please fill all fields.");
                return;
            }

            Subject subject1 = new Subject(1, subject, "sub");

            // Exam ID from logged moderator
            int examId = LoggedInSession.getLoggedInQuestionModerator().getAssignedExamID();

            // Build Question object
            Question q = new Question(qId, qText, "active", difficulty, subject1, examId);

            // Save directly using saveObject()
            BinaryFileHelper.saveObject(QUESTION_FILE, q);

            questionList.add(q);

            alert("Question added!");

        } catch (Exception e) {
            alert("Something went wrong.");
        }
    }

    // ---------------- VIEW OPTIONS FOR A QUESTION ----------------
    @FXML
    public void handleSeeOptionButton(ActionEvent actionEvent) {

        optionList.clear();

        try {
            int qId = Integer.parseInt(questionIdTextField.getText());

            // Load all questions
            ArrayList<Question> allQuestions = BinaryFileHelper.readAllObjects(QUESTION_FILE);

            Question target = null;

            // Find the question
            for (Question q : allQuestions) {
                if (q.getId() == qId) {
                    target = q;
                    break;
                }
            }

            if (target == null) {
                alert("No question found with this ID.");
                return;
            }

            // Question found — now show its options
            ArrayList<Option> opts = target.getOptions();

            if (opts == null || opts.isEmpty()) {
                alert("This question has no options added.");
                return;
            }

            optionList.clear();
            optionList.addAll(opts);
            optionsTableView.getItems().clear();
            optionsTableView.getItems().addAll(opts);

        } catch (Exception e) {
            alert("Invalid Question ID.");
        }
    }

    // ---------------- ALERT UTILITY ----------------
    private void alert(String message) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText(null);
        a.setContentText(message);
        a.showAndWait();
    }

    @FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "ataul/question-modarator-dash-view.fxml", "Dashboard");
    }
}