package com.example.medicalentranceexam3.ataul;

import com.example.medicalentranceexam3.utils.BinaryFileHelper;
import com.example.medicalentranceexam3.utils.SceneSwitcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CreateExamView implements Initializable {

    @FXML
    private TextField titleTextField;

    @FXML
    private DatePicker examDatePicker;

    @FXML
    private TableView<Exam> examTableView;

    @FXML
    private TableColumn<Exam, Integer> examIdCol;

    @FXML
    private TableColumn<Exam, String> titleCol;

    @FXML
    private TableColumn<Exam, String> statusCol;

    @FXML
    private TableColumn<Exam, LocalDate> examDateCol;

    private final File FILE_PATH = new File("data/exams.bin");

    private ArrayList<Exam> examList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        examIdCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleIntegerProperty(cell.getValue().getId()).asObject());
        titleCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getTitle()));
        statusCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getStatus()));
        examDateCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleObjectProperty<>(cell.getValue().getExamDate()));

        loadExams();
    }

    private void loadExams() {
        ArrayList<Exam> list = BinaryFileHelper.readAllObjects(FILE_PATH);
        examList.addAll(list);
        examTableView.getItems().addAll(examList);
    }

    @FXML
    public void handleCreateButton() {
        String title = titleTextField.getText().trim();
        LocalDate examDate = examDatePicker.getValue();

        if (title.isEmpty() || examDate == null) {
            showAlert("Error", "Please enter exam title and date.");
            return;
        }

        int newId = generateExamID();

        Exam exam = new Exam(
                newId,
                title,
                "Draft",             // default status
                LocalDate.now(),     // publish date = now
                examDate
        );

        examList.add(exam);
        BinaryFileHelper.writeAllObjects(FILE_PATH, examList);

        showAlert("Success", "Exam created successfully.");

        titleTextField.clear();
        examDatePicker.setValue(null);
    }

    private int generateExamID() {
        if (examList.isEmpty()) return 1;
        return examList.get(examList.size() - 1).getId() + 1;
    }

    @FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.sceneSwitch(actionEvent, "ataul/director-dash-view.fxml", "Dashboard");
    }

    private void showAlert(String title, String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.show();
    }
}