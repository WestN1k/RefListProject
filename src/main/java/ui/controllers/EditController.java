package ui.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.model.Author;
import logic.model.CommonItem;
import ui.Main;
import ui.ShowAlert;

import java.io.IOException;

public class EditController {
    private final static int MAX_COUNT_AUTHORS = 4;
    private int countAuthors = 0;
    private ShowAlert show = new ShowAlert();

    @FXML
    private ChoiceBox<String> source_view_choice_box;

    @FXML
    private Pane EditContentPane;

    @FXML ListView<Author> authorsListView;

    @FXML
    private Button addAuthorsButton;
    @FXML
    private Button deleteAuthorButton;

    @FXML
    private HBox typeObjectHBox;

    private Stage dialogStage;
    private CommonItem item;
    private boolean okClicked = false;
    private ControllerInterface controller;

    private Main mainApp;

    @FXML
    private void initialize() {
        ObservableList<String> sourceViews = FXCollections.observableArrayList("Журнальные статьи",
//                "Монографии",
                "Авторефераты",
                "Диссертации",
//                "Обзоры (аналитика)",
//                "Патенты",
//                "Материалы конференций",
//                "Интернет-документы",
//                "Учебные пособия",
//                "Словари",
                "Учебники");

        source_view_choice_box.setItems(sourceViews);

        source_view_choice_box.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                String choiceValue = source_view_choice_box.getItems().get((Integer) newValue);
                switchChoiceValue(choiceValue);
            }
        });

        deleteAuthorButton.setDisable(true);

        authorsListView.setCellFactory(param -> new ListCell<Author>() {
            @Override
            protected void updateItem(Author item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null || item.getSurname() == null) {
                    setText("");
                } else {
                    setText(item.getShortRecord());
                }

                if (authorsListView.getItems().size() > 0) {
                    deleteAuthorButton.setDisable(false);
                } else {
                    deleteAuthorButton.setDisable(true);
                }
            }
        });

        authorsListView.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                System.out.println(authorsListView.getSelectionModel().getSelectedItem());

                addEditAuthor(authorsListView.getSelectionModel().getSelectedItem());
            }
        });
    }

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    public void setEditContentPane(Node node) {
        EditContentPane.getChildren().setAll(node);
    }

    public void loadPane(String resourcePath) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resourcePath));
        setEditContentPane(loader.load());
        this.controller = loader.getController();
        controller.setItem(this.item);
    }

    public void switchChoiceValue(String choiceValue) {
        try {
            switch (choiceValue) {
                case "Учебники":
                    loadPane("/fxml/editTypes/manual.fxml");
                    break;
                case "Монографии":
                    loadPane("/fxml/editTypes/monography.fxml");
                    break;
                case "Журнальные статьи":
                    loadPane("/fxml/editTypes/journal.fxml");
                    break;
                case "Авторефераты":
                    loadPane("/fxml/editTypes/synopsis.fxml");
                    break;
                case "Диссертации":
                    loadPane("/fxml/editTypes/dissertation.fxml");
                    break;
                case "Обзоры (аналитика)":
                    loadPane("/fxml/editTypes/review.fxml");
                    break;
                case "Патенты":
                    loadPane("/fxml/editTypes/patents.fxml");
                    break;
                case "Материалы конференций":
                    loadPane("/fxml/editTypes/conference.fxml");
                    break;
                case "Интернет-документы":
                    loadPane("/fxml/editTypes/web-document.fxml");
                    break;
                case "Учебные пособия":
                    loadPane("/fxml/editTypes/tutorial.fxml");
                    break;
                case "Словари":
                    loadPane("/fxml/editTypes/dictionary.fxml");
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setCommonItem(CommonItem item) {
        this.item = item;
        if (item.getItemType() != null) {
            switchChoiceValue(item.getItemType());

            for (Author author: item.getAuthors()) {
                authorsListView.getItems().add(author);
            }

            typeObjectHBox.setVisible(false);
        }
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            item.clearAuthorsList();

            for (Author author: authorsListView.getItems()) {
                item.setAuthor(author);
            }

            item.setName(controller.getNameField());
            item.setPublisher(controller.getPublisherField());
            item.setCity(controller.getCityField());
            item.setItemType(controller.getType());
            item.setDate(controller.getDate());
            item.setEditor(controller.getEditor());
            item.setRegaliaAuthor(controller.getRegaliaAuthor());
            item.setTopic(controller.getTopic());
            item.setUrl(controller.getUrl());
            item.setWorkStatus(controller.getWorkStatus());
            item.setNumPatent(controller.getNumPatent());
            item.setNumJournal(controller.getNumberField());

            item.setYear(Integer.parseInt(controller.getYearField()));
            item.setPages(Integer.parseInt(controller.getPagesField()));
            item.setStartPage(Integer.parseInt(controller.getStartPage()));
            item.setEndPage(Integer.parseInt(controller.getEndPage()));
            item.setNumBull(Integer.parseInt(controller.getNumBull()));

            okClicked = true;
            dialogStage.close();
        } else {
            show.showAlert("ошибка обработки текста", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    @FXML
    private void addNewAuthor() {
        Author tempAuthor = new Author();
        boolean okClicked = mainApp.showAuthorEditDialog(tempAuthor);
        addAuthorsButton.setDisable(false);
        if (countAuthors < MAX_COUNT_AUTHORS) {
            if (okClicked) {
                authorsListView.getItems().add(tempAuthor);
                countAuthors += 1;
            }
        } else {
            addAuthorsButton.setDisable(true);
        }
    }

    private void addEditAuthor(Author author) {
        boolean okClicked = mainApp.showAuthorEditDialog(author);
        if (okClicked) {
            authorsListView.refresh();
        }
    }

    @FXML
    private void deleteAuthor(ActionEvent event) {
        int index = authorsListView.getSelectionModel().getSelectedIndex();
        if (index > -1) {
            authorsListView.getItems().remove(index);
        }
    }

    private boolean isInputValid(){
        try {

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
