package ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import logic.model.CommonItem;

public class ManualController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField publisherField;
    @FXML
    private TextField yearField;
    @FXML
    private TextField pagesField;


    @FXML
    private void initialize()  {
    }

    public void setItem(CommonItem item) {
        if (item != null) {
            nameField.setText(item.getName());
            publisherField.setText(item.getPublisher());
            yearField.setText(Integer.toString(item.getYear()));
            pagesField.setText(Integer.toString(item.getPages()));
            cityField.setText(item.getCity());
        } else {
            nameField.setText("");
            publisherField.setText("");
            yearField.setText("");
            pagesField.setText("");
            cityField.setText("");
        }
    }

    public String getNameField() {
        return nameField.getText();
    }

    public String getPublisherField() {
        return publisherField.getText();
    }




}
