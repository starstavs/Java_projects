module org.example.whowantstobeamillionaireapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.whowantstobeamillionaireapp to javafx.fxml;
    exports org.example.whowantstobeamillionaireapp;
}