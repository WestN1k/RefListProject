package com.yamanov.ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import com.yamanov.logic.model.CommonItem;

public class DictionaryController extends CommonController{

//
//    @Override
//    public void setItem(CommonItem item) {
//        if (item != null) {
//            nameField.setText(item.getName());
//            publisherField.setText(item.getPublisher());
//            yearField.setText(Integer.toString(item.getYear()));
//            pagesField.setText(Integer.toString(item.getPages()));
//            cityField.setText(item.getCity());
//
//        } else {
//            nameField.setText("");
//            publisherField.setText("");
//            yearField.setText("");
//            pagesField.setText("");
//            cityField.setText("");
//        }
//    }

    public String getNameField() {
        return nameField.getText();
    }

    public String getPublisherField() {
        return publisherField.getText();
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

    public String getType() {
        return "Словари";
    }

}
