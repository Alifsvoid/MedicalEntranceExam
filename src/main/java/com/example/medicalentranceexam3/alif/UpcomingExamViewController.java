package com.example.medicalentranceexam3.alif;

import com.example.medicalentranceexam3.ataul.Exam;
import com.example.medicalentranceexam3.utils.BinaryFileHelper;
import com.example.medicalentranceexam3.utils.SceneSwitcher;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
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
import java.util.ResourceBundle;

public class UpcomingExamViewController implements Initializable {

    @FXML
    private TableView<Exam> examTable;

    @FXML
    private TableColumn<Exam, Integer> examIdCol;

    @FXML
    private TableColumn<Exam, String> titleCol;

    @FXML
    private TableColumn<Exam, LocalDate> dateCol;

    @FXML
    private TableColumn<Exam, LocalDate> publishCol;

    private final File FILE_PATH = new File("data/exams.bin");
    private final ObservableList<Exam> publishedExams = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        examIdCol.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getId()).asObject());
        titleCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getTitle()));
        dateCol.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getExamDate()));
        publishCol.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getPublishDate()));

        loadPublishedExams();
    }

    private void loadPublishedExams() {
        ArrayList<Exam> allExams = BinaryFileHelper.readAllObjects(FILE_PATH);

        publishedExams.addAll(allExams);

        examTable.setItems(publishedExams);
    }

    @FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.sceneSwitch(actionEvent, "alif/applicant-dash-view.fxml", "DashBoard");
    }


}
