module com.example.medicalentranceexam3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.medicalentranceexam3 to javafx.fxml;
    opens com.example.medicalentranceexam3.ataul to javafx.fxml;

    exports com.example.medicalentranceexam3;
//    exports com.example.medicalentranceexam3.ataul;

}