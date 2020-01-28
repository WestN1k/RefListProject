package ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import logic.model.CommonItem;

public class MonographyController extends CommonController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField publisherField;
    @FXML
    private TextField yearField;
    @FXML
    private TextField numberField;
    @FXML
    private TextField startPage;
    @FXML
    private TextField endPage;

    @FXML
    private void initialize()  {
    }

    @Override
    public void setItem(CommonItem item) {
        if (item != null) {
            nameField.setText(item.getName());
            publisherField.setText(item.getPublisher());
            yearField.setText(Integer.toString(item.getYear()));
            numberField.setText(item.getNumJournal());
            startPage.setText(Integer.toString(item.getStartPage()));
            endPage.setText(Integer.toString(item.getEndPage()));
        } else {
            numberField.setText("");
            startPage.setText("");
            endPage.setText("");
            nameField.setText("");
            publisherField.setText("");
            yearField.setText("");
        }
    }

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
        return "Монографии";
    }

}
