module RefList {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.base;
    requires opencsv;

    opens ui to javafx.graphics, javafx.fxml;
}