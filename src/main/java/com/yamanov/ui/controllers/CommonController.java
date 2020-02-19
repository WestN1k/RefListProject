package com.yamanov.ui.controllers;

import com.yamanov.logic.model.CommonItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.converter.IntegerStringConverter;

import java.util.List;
import java.util.Objects;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonController implements ControllerInterface {

    @FXML
    protected TextField nameField;
    @FXML
    protected TextField publisherField;
    @FXML
    protected TextField yearField;
    @FXML
    protected TextField numberField;
    @FXML
    protected TextField startPage;
    @FXML
    protected TextField endPage;
    @FXML
    protected TextArea topicField;
    @FXML
    protected TextField cityField;
    @FXML
    protected TextField pagesField;
    @FXML
    protected ChoiceBox<String> regalyAuthorField;
    @FXML
    protected TextField workStatusField;
    @FXML
    protected TextField patentNumberField;
    @FXML
    protected TextField bullNumberField;
    @FXML
    protected TextField dateField;
    @FXML
    protected TextField editorField;
    @FXML
    protected TextArea urlField;

    @FXML
    public void initialize() {
        ObservableList<String> regalyAuthorsList = FXCollections.observableArrayList(
                "д-р мед. наук", "канд. мед. наук", "доц.", "проф.", "ст. науч. сотр.", "мл. науч. сотр.", "акад.");
        if (regalyAuthorField != null) {
            regalyAuthorField.setItems(regalyAuthorsList);
            regalyAuthorField.getSelectionModel().selectFirst();
        }

        if (startPage != null) {
            startPage.clear();
            startPage.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), null, integerFilter));
        }

        if (yearField != null) {
            yearField.clear();
            yearField.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), null, integerFilter));
        }

        if (pagesField != null) {
            pagesField.clear();
            pagesField.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), null, integerFilter));
        }

        if (endPage != null) {
            endPage.clear();
            endPage.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), null, integerFilter));
        }

        if (bullNumberField != null) {
            bullNumberField.clear();
            bullNumberField.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), null, integerFilter));
        }
    }

    @Override
    public void setItem(CommonItem item) {

        if (nameField != null) {
            nameField.setText(item.getName());
        }

        if (publisherField != null) {
            publisherField.setText(item.getPublisher());
        }

        if (numberField != null) {
            numberField.setText(item.getNumJournal());
        }

        if (topicField != null) {
            topicField.setText(item.getTopic());
        }

        if (cityField != null) {
            cityField.setText(item.getCity());
        }

        if (regalyAuthorField != null) {
            regalyAuthorField.getSelectionModel().select(item.getRegaliaAuthor());
        }

        if (workStatusField != null) {
            workStatusField.setText(item.getWorkStatus());
        }

        if (patentNumberField != null) {
            patentNumberField.setText(item.getNumPatent());
        }

        if (dateField != null) {
            dateField.setText(item.getDate());
        }

        if (editorField != null) {
            editorField.setText(item.getEditor());
        }

        if (urlField != null) {
            urlField.setText(item.getUrl());
        }

        if (yearField != null) {
            yearField.setText(item.getYear() != null ? item.getYear().toString() : "");
        }

        if (pagesField != null) {
            pagesField.setText(item.getPages() != null ? item.getPages().toString() : "");
        }

        if (startPage != null) {
            startPage.setText(item.getStartPage() != null ? item.getStartPage().toString() : "");
        }

        if (endPage != null) {
            endPage.setText(item.getEndPage() != null ? item.getEndPage().toString() : "");
        }

        if (bullNumberField != null) {
            bullNumberField.setText(item.getNumBull() != null ? item.getNumBull().toString() : "");
        }
    }

    @Override
    public String getNameField() {
        return null;
    }

    @Override
    public String getPublisherField() {
        return null;
    }

    @Override
    public String getYearField() {
        return "0";
    }

    @Override
    public String getCityField() {
        return null;
    }

    @Override
    public String getPagesField() {
        return "0";
    }

    @Override
    public String getNumberField() {
        return "0";
    }

    @Override
    public String getStartPage() {
        return "0";
    }

    @Override
    public String getEndPage() {
        return "0";
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public String getDate() {
        return "0";
    }

    @Override
    public String getRegaliaAuthor() {
        return null;
    }

    @Override
    public String getWorkStatus() {
        return null;
    }

    @Override
    public String getEditor() {
        return null;
    }

    @Override
    public String getNumPatent() {
        return "0";
    }

    @Override
    public String getNumBull() {
        return "0";
    }

    @Override
    public String getTopic() {
        return null;
    }

    @Override
    public String getUrl() {
        return null;
    }

    UnaryOperator<TextFormatter.Change> integerFilter = change -> {
        String newText = change.getControlNewText();
        if(newText.matches("[0-9]+")) {
            return change;
        }
        return null;
    };

    public List<Control> getAllNotNullFields() {
        Stream<Control> fields = Stream.of(nameField, publisherField, yearField, numberField, startPage, endPage,
                topicField, cityField, pagesField, regalyAuthorField, workStatusField, patentNumberField,
                bullNumberField, dateField, editorField, urlField);
        return fields.filter(Objects::nonNull).collect(Collectors.toList());
    }

}
