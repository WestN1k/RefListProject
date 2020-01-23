package ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import logic.model.CommonItem;

public class SynopsisController extends CommonController{
    @FXML
    private TextField nameField;
    @FXML
    private TextField regalyAuthorField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField yearField;
    @FXML
    private TextField pagesField;

    @Override
    public void setItem(CommonItem item) {
        if (item != null) {
            nameField.setText(item.getName());
            regalyAuthorField.setText(item.getRegaliaAuthor());
            yearField.setText(Integer.toString(item.getYear()));
            cityField.setText(item.getCity());
            pagesField.setText(Integer.toString(item.getPages()));
        } else {
            regalyAuthorField.setText("");
            cityField.setText("");
            pagesField.setText("");
            nameField.setText("");
            yearField.setText("");
        }
    }

    public String getNameField() {
        return nameField.getText();
    }

    @Override
    public String getRegaliaAuthor() {
        return regalyAuthorField.getText();
    }

    public String getYearField() {
        return yearField.getText();
    }

    public String getCityField() {
        return cityField.getText();
    }

    public String getPagesField() {
        return pagesField.getText();
    }

    @Override
    public String getType() {
        return "Авторефераты";
    }
}
