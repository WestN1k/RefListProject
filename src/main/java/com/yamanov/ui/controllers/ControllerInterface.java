package com.yamanov.ui.controllers;

import com.yamanov.logic.model.CommonItem;
import javafx.scene.control.Control;

import java.util.List;

public interface ControllerInterface {
    void initialize();
    void setItem(CommonItem item);
    String getNameField();
    String getPublisherField();
    String getYearField();
    String getCityField();
    String getPagesField();
    String getNumberField();
    String getStartPage();
    String getEndPage();
    String getType();
    String getDate();
    String getRegaliaAuthor();
    String getWorkStatus();
    String getEditor();
    String getNumPatent();
    String getNumBull();
    String getTopic();
    String getUrl();
    List<Control> getAllNotNullFields();
}
