package ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logic.model.Author;
import logic.model.CommonItem;

public class AuthorController {

    @FXML
    private TextField authorSurnameField;
    @FXML
    private TextField authorNameField;
    @FXML
    private TextField authorPatronymicField;

    private Stage dialogStage;

    private boolean okClicked = false;

    private Author author;

    @FXML
    private void initialize() {
    }

    public void setAuthorDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


    public void setAuthor(Author author) {
        this.author = author;

        if (author != null) {
            authorSurnameField.setText(author.getSurname());
            authorNameField.setText(author.getName());
            authorPatronymicField.setText(author.getPatronymic());
        } else {
            authorSurnameField.setText("");
            authorNameField.setText("");
            authorPatronymicField.setText("");
        }
    }

    @FXML
    private void authorHandleOk() {
//        if (isInputValid()) {
        author.setSurname(authorSurnameField.getText());
        author.setName(authorNameField.getText());
        author.setPatronymic(authorPatronymicField.getText());

        okClicked = true;
        dialogStage.close();
//        }
    }

    @FXML
    private void authorHandleCancel() {
        dialogStage.close();
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    public void deleteAuthor() {
        
    }

}
