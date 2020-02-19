package com.yamanov.ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import com.yamanov.logic.model.CommonItem;

public class ConferenceController extends CommonController {

//
//    @Override
//    public void setItem(CommonItem item) {
//        nameField.setText(item.getName());
//        topicField.setText(item.getTopic());
//        yearField.setText(Integer.toString(item.getYear()));
//        cityField.setText(item.getCity());
//        pagesField.setText(Integer.toString(item.getPages()));
//        startPage.setText(Integer.toString(item.getStartPage()));
//        endPage.setText(Integer.toString(item.getEndPage()));
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
        return topicField.getText();
    }

    @Override
    public String getType() {
        return "Материалы конференций";
    }
}
