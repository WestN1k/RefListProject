package com.yamanov.ui.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.yamanov.logic.model.Author;

import java.util.regex.Pattern;

public class AuthorController {

    private static final String ERROR_COLOR = "#E9967A";
    private static final String SUCCESS_COLOR = "#BEF574";

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
        if(isInputValid()) {
            author.setSurname(authorSurnameField.getText());
            author.setName(authorNameField.getText());
            author.setPatronymic(authorPatronymicField.getText());
            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void authorHandleCancel() {
        dialogStage.close();
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    private boolean isInputValid() {
        if (validatePattern(authorNameField.getText()) &&
                validatePattern(authorSurnameField.getText()) &&
                validatePattern(authorPatronymicField.getText()) ) {
            return true;
        } else {
            if (validatePattern(authorNameField.getText())) {
                authorNameField.setStyle(String.format("-fx-background-color: %s;", SUCCESS_COLOR));
            } else {
                authorNameField.setStyle(String.format("-fx-background-color: %s;", ERROR_COLOR));
            }

            if (validatePattern(authorSurnameField.getText())) {
                authorSurnameField.setStyle(String.format("-fx-background-color: %s;", SUCCESS_COLOR));
            } else {
                authorSurnameField.setStyle(String.format("-fx-background-color: %s;", ERROR_COLOR));
            }

            if (validatePattern(authorPatronymicField.getText())) {
                authorPatronymicField.setStyle(String.format("-fx-background-color: %s;", SUCCESS_COLOR));
            } else {
                authorPatronymicField.setStyle(String.format("-fx-background-color: %s;", ERROR_COLOR));
            }
        }

        return false;
    }

    private static boolean validatePattern(String str) {
        String stringPattern = "[а-яА-Я\\-]+";
        Pattern pattern = Pattern.compile(stringPattern);

        try{
            return pattern.matcher(str).matches();
        } catch (NullPointerException e){
            return false;
        }
    }
}
