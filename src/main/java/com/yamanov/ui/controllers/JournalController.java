package com.yamanov.ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import com.yamanov.logic.model.CommonItem;

public class JournalController extends CommonController {


    public String getNameField() {
        return nameField.getText();
    }

    public String getPublisherField() {
        return publisherField.getText();
    }

    public String getYearField() {
        return yearField.getText();
    }

    public String getNumberField() {
        return numberField.getText();
    }

    public String getStartPage() {
        return startPage.getText();
    }

    public String getEndPage() {
        return endPage.getText();
    }

    @Override
    public String getType() {
        return "Журнальные статьи";
    }

}
