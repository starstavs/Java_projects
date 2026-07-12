module org.example.whowantstobeamillionaireapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.tekwill.millionaire to javafx.fxml;
    exports edu.tekwill.millionaire;
}