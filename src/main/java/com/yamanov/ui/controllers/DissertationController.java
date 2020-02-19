package com.yamanov.ui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import com.yamanov.logic.model.CommonItem;

public class DissertationController extends CommonController{

//    @FXML
//    private void initialize() {
//        ObservableList<String> regalyAuthorsList = FXCollections.observableArrayList(
//                "д-р мед. наук", "канд. мед. наук", "доц.", "проф.", "ст. науч. сотр.", "мл. науч. сотр.", "акад.");
//        regalyAuthorField.setItems(regalyAuthorsList);
//        regalyAuthorField.getSelectionModel().selectFirst();
//    }

//    @Override
//    public void setItem(CommonItem item) {
//        if (item != null) {
//            nameField.setText(item.getName());
//            regalyAuthorField.getSelectionModel().select(item.getRegaliaAuthor());
//            yearField.setText(Integer.toString(item.getYear()));
//            workStatusField.setText(item.getWorkStatus());
//            cityField.setText(item.getCity());
//            pagesField.setText(Integer.toString(item.getPages()));
//            startPage.setText(Integer.toString(item.getStartPage()));
//            endPage.setText(Integer.toString(item.getEndPage()));
//        } else {
//            workStatusField.setText("");
////            regalyAuthorField.setText("");
//            cityField.setText("");
//            nameField.setText("");
//            yearField.setText("");
//            pagesField.setText("");
//            startPage.setText("");
//            endPage.setText("");
//        }
//    }

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
        return regalyAuthorField.getSelectionModel().getSelectedItem();
    }

    @Override
    public String getWorkStatus() {
        return workStatusField.getText();
    }

    @Override
    public String getType() {
        return "Диссертации";
    }
}
