package com.yamanov.ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import com.yamanov.logic.model.CommonItem;

public class TutorialController extends CommonController {

//    @Override
//    public void setItem(CommonItem item) {
//        if (item != null) {
//            nameField.setText(item.getName());
//            publisherField.setText(item.getPublisher());
//            yearField.setText(Integer.toString(item.getYear()));
//            pagesField.setText(Integer.toString(item.getPages()));
//            cityField.setText(item.getCity());
//            editorField.setText(item.getEditor());
//        } else {
//            nameField.setText("");
//            publisherField.setText("");
//            yearField.setText("");
//            pagesField.setText("");
//            cityField.setText("");
//            editorField.setText("");
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

    @Override
    public String getEditor() {
        return editorField.getText();
    }

    @Override
    public String getType() {
        return "Учебные пособия";
    }
}
