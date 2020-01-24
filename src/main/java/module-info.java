module RefList {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.base;
    requires opencsv;

    opens ui.controllers to javafx.graphics, javafx.fxml;
    opens ui to javafx.graphics;
    exports ui;
}