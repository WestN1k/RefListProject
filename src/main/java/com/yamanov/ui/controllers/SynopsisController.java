package com.yamanov.ui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import com.yamanov.logic.model.CommonItem;

public class SynopsisController extends CommonController{

//    @Override
//    public void setItem(CommonItem item) {
//        if (item != null) {
//            nameField.setText(item.getName());
//            regalyAuthorField.getSelectionModel().select(item.getRegaliaAuthor());
//            yearField.setText(Integer.toString(item.getYear()));
//            cityField.setText(item.getCity());
//            pagesField.setText(Integer.toString(item.getPages()));
//            workStatusField.setText(item.getWorkStatus());
//        } else {
////            regalyAuthorField.setText("");
//            workStatusField.setText("");
//            cityField.setText("");
//            pagesField.setText("");
//            nameField.setText("");
//            yearField.setText("");
//        }
//    }

    public String getNameField() {
        return nameField.getText();
    }

    @Override
    public String getRegaliaAuthor() {
        return regalyAuthorField.getSelectionModel().getSelectedItem();
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

    public String getWorkStatus() {
        return workStatusField.getText();
    }

    @Override
    public String getType() {
        return "Авторефераты";
    }
}
