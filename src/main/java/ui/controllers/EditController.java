package ui.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.model.Author;
import logic.model.CommonItem;

import java.io.IOException;

public class EditController {

    @FXML
    private ChoiceBox<String> source_view_choice_box;

    @FXML
    private Pane EditContentPane;

    private Stage dialogStage;
    private CommonItem item;
    private boolean okClicked = false;
    private ManualController controller;


    @FXML
    private void initialize() {
        ObservableList<String> sourceViews = FXCollections.observableArrayList("Журнальные статьи",
                "Монографии", "Авторефераты", "Диссертации", "Обзоры (аналитика)", "Патенты", "Материалы конференций",
                "Интернет-документы", "Учебники", "Учебные пособия", "Словари");

        source_view_choice_box.setItems(sourceViews);
        source_view_choice_box.getSelectionModel().selectFirst();

        source_view_choice_box.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                String choiceValue = source_view_choice_box.getItems().get((Integer) newValue);
                switchChoiceValue(choiceValue);
            }
        });
    }

    public void setEditContentPane(Node node) {
        EditContentPane.getChildren().setAll(node);
    }

    public void loadManualPane() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/editTypes/manual.fxml"));
        setEditContentPane(loader.load());
        this.controller = loader.getController();
        controller.setItem(this.item);
    }

    public void loadMonographPane() throws IOException {
        setEditContentPane(FXMLLoader.load(getClass().getResource("/fxml/editTypes/monography.fxml")));
    }

    public void switchChoiceValue(String choiceValue) {
        switch (choiceValue) {
            case "Учебники":
                try {
                    loadManualPane();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "Монографии":
                try {
                    loadMonographPane();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;

    }

    public void setCommonItem(CommonItem item) {
        this.item = item;
    }

    public CommonItem getCommonItem() {
        return this.item;
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
//        if (isInputValid()) {
        item.setName(controller.getNameField());
        item.setPublisher(controller.getPublisherField());
        item.setYear(Integer.parseInt("1990"));
        item.setAuthor(new Author("Иванов", "Василий", "Петрович"));
        item.setCity("Астрахань");
        item.setPages(Integer.parseInt("20"));
        item.setItemType("Учебники");
//        item.setYear((short) Integer.parseInt(yearField.getText()));
//        item.setPages((short) Integer.parseInt(pagesField.getText()));
//        item.setCity(cityField.getText());
        okClicked = true;
        dialogStage.close();
//        }
    }



    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
}
