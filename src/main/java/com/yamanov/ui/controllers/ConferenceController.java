package com.yamanov.ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import com.yamanov.logic.model.CommonItem;

public class ConferenceController extends CommonController {

    @FXML
    private TextField nameField;
    @FXML
    private TextArea topicField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField yearField;
    @FXML
    private TextField pagesField;
    @FXML
    private TextField startPage;
    @FXML
    private TextField endPage;


    @Override
    public void setItem(CommonItem item) {
        if (item !=null) {
            nameField.setText(item.getName());
            topicField.setText(item.getTopic());
            yearField.setText(Integer.toString(item.getYear()));
            cityField.setText(item.getCity());
            pagesField.setText(Integer.toString(item.getPages()));
            startPage.setText(Integer.toString(item.getStartPage()));
            endPage.setText(Integer.toString(item.getEndPage()));
        } else {
            topicField.setText("");
            cityField.setText("");
            nameField.setText("");
            yearField.setText("");
            pagesField.setText("");
            startPage.setText("");
            endPage.setText("");
        }
    }

    @Override
    public String getNameField() {
        return nameField.getText();
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
    public String getStartPage() {
        return startPage.getText();
    }

    @Override
    public String getEndPage() {
        return endPage.getText();
    }

    @Override
    public String getRegaliaAuthor() {
        return topicField.getText();
    }

    @Override
    public String getType() {
        return "Материалы конференций";
    }
}
