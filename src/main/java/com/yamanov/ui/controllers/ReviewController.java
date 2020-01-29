package com.yamanov.ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import com.yamanov.logic.model.CommonItem;

public class ReviewController extends CommonController {
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

    @Override
    public String getNameField() {
        return nameField.getText();
    }

    @Override
    public String getPublisherField() {
        return publisherField.getText();
    }

    @Override
    public String getYearField() {
        return yearField.getText();
    }

    @Override
    public String getCityField() {
        return cityField.getText();
    }

    @Override
    public String getPagesField() {
        return pagesField.getText();
    }

    @Override
    public void setItem(CommonItem item) {
        if (item != null) {
            nameField.setText(item.getName());
            publisherField.setText(item.getPublisher());
            yearField.setText(Integer.toString(item.getYear()));
            cityField.setText(item.getCity());
            pagesField.setText(Integer.toString(item.getPages()));
        } else {
            cityField.setText("");
            publisherField.setText("");
            pagesField.setText("");
            nameField.setText("");
            yearField.setText("");
        }
    }

    @Override
    public String getType() {
        return "Обзоры (аналитика)";
    }
}
