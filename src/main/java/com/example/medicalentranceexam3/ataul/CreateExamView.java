package com.example.medicalentranceexam3.ataul;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class CreateExamView
{
    @javafx.fxml.FXML
    private TextField titleTextField;
    @javafx.fxml.FXML
    private TableColumn<Exam, String> titleCol;
    @javafx.fxml.FXML
    private TableView<Exam> examTableView;
    @javafx.fxml.FXML
    private TableColumn<Exam, String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<Exam, Integer> examIdCol;
    @javafx.fxml.FXML
    private DatePicker publishDatePicker;
    @javafx.fxml.FXML
    private TableColumn<Exam, LocalDate> publishDateCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleCreateButton(ActionEvent actionEvent) {
    }
}