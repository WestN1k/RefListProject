package ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import logic.model.CommonItem;

public class DissertationController extends CommonController{
    @FXML
    private TextField nameField;
    @FXML
    private TextField regalyAuthorField;
    @FXML
    private TextField workStatusField;
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
        if (item != null) {
            nameField.setText(item.getName());
            regalyAuthorField.setText(item.getRegaliaAuthor());
            yearField.setText(Integer.toString(item.getYear()));
            workStatusField.setText(item.getWorkStatus());
            cityField.setText(item.getCity());
            pagesField.setText(Integer.toString(item.getPages()));
            startPage.setText(Integer.toString(item.getStartPage()));
            endPage.setText(Integer.toString(item.getEndPage()));
        } else {
            workStatusField.setText("");
            regalyAuthorField.setText("");
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
        return regalyAuthorField.getText();
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
