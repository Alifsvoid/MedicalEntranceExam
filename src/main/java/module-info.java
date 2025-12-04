module com.example.medicalentranceexam3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.medicalentranceexam3 to javafx.fxml;
//    opens com.example.medicalentranceexam3.alif to javafx.fxml;
    opens com.example.medicalentranceexam3.alif to javafx.base, javafx.fxml;
    opens com.example.medicalentranceexam3.ataul to javafx.base, javafx.fxml;

    exports com.example.medicalentranceexam3;
//    exports com.example.medicalentranceexam3.ataul;

}