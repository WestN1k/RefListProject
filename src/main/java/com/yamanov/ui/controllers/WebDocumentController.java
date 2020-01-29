package com.yamanov.ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import com.yamanov.logic.model.CommonItem;

public class WebDocumentController extends CommonController {
    @FXML
    private TextField nameField;
    @FXML
    private TextArea urlField;
    @FXML
    private TextField dateField;

    @Override
    public void setItem(CommonItem item) {
        if (item != null) {
            nameField.setText(item.getName());
            urlField.setText(item.getUrl());
            dateField.setText(item.getDate());
        } else {
            urlField.setText("");
            dateField.setText("");
            nameField.setText("");
        }
    }

    @Override
    public String getNameField() {
        return nameField.getText();
    }

    @Override
    public String getDate() {
        return dateField.getText();
    }

    @Override
    public String getUrl() {
        return urlField.getText();
    }

    @Override
    public String getType() {
        return "Интернет-документы";
    }
}
