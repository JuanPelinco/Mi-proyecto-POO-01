module pe.edu.upeu {
    requires javafx.controls;
    requires javafx.fxml;


    opens pe.edu.upeu to javafx.fxml;
    exports pe.edu.upeu;
}