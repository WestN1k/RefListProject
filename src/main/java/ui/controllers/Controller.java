package ui.controllers;

import logic.model.CommonItem;

public interface Controller {
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
}
