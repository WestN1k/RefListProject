module RefList {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.fxml;
    requires opencsv;

    opens com.yamanov.ui.controllers to javafx.graphics, javafx.fxml;
    opens com.yamanov.ui to javafx.graphics;
}