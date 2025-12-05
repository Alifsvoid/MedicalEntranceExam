package com.example.medicalentranceexam3.ataul;

import com.example.medicalentranceexam3.LoggedInSession;
import com.example.medicalentranceexam3.utils.BinaryFileHelper;
import com.example.medicalentranceexam3.utils.SceneSwitcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
//h

public class AddSubjectView {

    @FXML private TextField subjectTextField;
    @FXML private TextField codeTextField;
    @FXML private TableView<Subject> subjectTableView;
    @FXML private TableColumn<Subject, Integer> idCol;
    @FXML private TableColumn<Subject, String> subjectCol;
    @FXML private TableColumn<Subject, String> codeCol;

    private final File SUBJECT_FILE = new File("data/subjects.bin");
    private ArrayList<Subject> subjectList = new ArrayList<>();
    private ObservableList<Subject> tableData = FXCollections.observableArrayList();
    @FXML
    private TextField subIDTextField;

    @javafx.fxml.FXML
    public void initialize() {
        // Setup table columns
        idCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("id"));
        subjectCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("name"));
        codeCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("code"));

        // Load existing subjects from file
        subjectList = BinaryFileHelper.readAllObjects(SUBJECT_FILE);
        tableData.addAll(subjectList);
        subjectTableView.setItems(tableData);
    }

    
    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    private void showSuccess(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @Deprecated
    public void handleBackButton(ActionEvent event) throws IOException {
        // Example back button, adjust FXML path as needed
        if(LoggedInSession.getLoggedInQuestionModerator() == null){

        SceneSwitcher.sceneSwitch(event, "ataul/director-dash-view.fxml", "Dashboard");
        } else {

        SceneSwitcher.sceneSwitch(event, "ataul/question-modarator-dash-view.fxml", "Dashboard");
        }
    }

    @FXML
    public void handleAddButton(ActionEvent actionEvent) {
        String name = subjectTextField.getText().trim();
        String code = codeTextField.getText().trim();
        int id = Integer.parseInt(subIDTextField.getText());

        if (name.isEmpty() || code.isEmpty()) {
            showError("Please enter both subject name and code.");
            return;
        }

        // Generate ID (max existing ID + 1)


        Subject newSubject = new Subject(id, name, code);
        subjectList.add(newSubject);

        // Save updated list
        BinaryFileHelper.writeAllObjects(SUBJECT_FILE, subjectList);

        // Update table
        tableData.clear();
        tableData.addAll(subjectList);

        // Clear inputs
        subjectTextField.clear();
        codeTextField.clear();

        showSuccess("Subject added successfully.");
    }
}
