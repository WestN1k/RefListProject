package com.yamanov.ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import com.yamanov.logic.model.CommonItem;


public class PatentController extends CommonController {

//    @Override
//    public void setItem(CommonItem item) {
//        if (item != null) {
//            nameField.setText(item.getName());
//            yearField.setText(Integer.toString(item.getYear()));
//            patentNumberField.setText(item.getNumPatent());
//            bullNumberField.setText(Integer.toString(item.getNumBull()));
//            dateField.setText(item.getDate());
//        } else {
//            nameField.setText("");
//            yearField.setText("");
//            patentNumberField.setText("");
//            bullNumberField.setText("");
//            dateField.setText("");
//        }
//
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
    public String getDate() {
        return dateField.getText();
    }

    @Override
    public String getNumPatent() {
        return patentNumberField.getText();
    }

    @Override
    public String getNumBull() {
        return bullNumberField.getText();
    }

    @Override
    public String getType() {
        return "Патенты";
    }
}
