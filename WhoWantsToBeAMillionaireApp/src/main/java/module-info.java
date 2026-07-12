module org.example.whowantstobeamillionaireapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.commons.csv;


    opens edu.tekwill.millionaire to javafx.fxml;
    exports edu.tekwill.millionaire;
    exports edu.tekwill.millionaire.controler;
    opens edu.tekwill.millionaire.controler to javafx.fxml;
}