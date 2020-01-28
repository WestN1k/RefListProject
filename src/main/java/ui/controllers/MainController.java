package ui.controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import logic.AppProperties;
import logic.ToCSV;
import logic.format.FormatText;
import logic.model.Author;
import logic.model.CommonItem;
import ui.Main;
import ui.ShowAlert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class MainController {

    private final static String CSV_NAME = "/список литературы.csv";

    @FXML
    private Button add_item_button;
    @FXML
    private Button deleteItemButton;

    @FXML
    private ListView<CommonItem> itemsView = new ListView<>();

    private Main mainApp;

    FormatText format = new FormatText();

    private ShowAlert showAlert = new ShowAlert();

    public MainController() {
    }

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }


    @FXML
    private void initialize() {
        itemsView.setCellFactory(param -> new ListCell<CommonItem>(){
            @Override
            protected void updateItem(CommonItem item, boolean empty) {
                super.updateItem(item, empty);
                if(empty || item == null || item.getItemType() == null){
                    setText("");
                } else {
                    setText(format.getFormatText(item));
                    deleteItemButton.setDisable(false);
                }
            }
        });

        itemsView.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                System.out.println(itemsView.getSelectionModel().getSelectedItem());

                handleEditItem(itemsView.getSelectionModel().getSelectedItem());
            }
        });

        deleteItemButton.setDisable(true);
    }

    @FXML
    public void addNewItem(ActionEvent event) {
        CommonItem tempItem = new CommonItem();
        boolean okClicked = mainApp.showItemEditDialog(tempItem);
        if (okClicked) {
            itemsView.getItems().add(tempItem);
        }
    }

    @FXML
    public void deleteItem(ActionEvent event) {
        int index = itemsView.getSelectionModel().getSelectedIndex();
        if (index > -1) {
            itemsView.getItems().remove(index);
        }
    }

    @FXML
    public void saveToCsv(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {
        ObservableList<CommonItem> valuesList = itemsView.getItems();
        if (valuesList.isEmpty()) {
            showAlert.showAlert("нет данных для создания отчета", Alert.AlertType.CONFIRMATION);
        } else {
            boolean result = ToCSV.addToCSV(getCurrentFolder() + CSV_NAME, valuesList);
            if (result) {
                showAlert.showAlert("отчет создан", Alert.AlertType.CONFIRMATION);
                clearTable();
            } else {
                showAlert.showAlert("произошла ошибка при сохранении отчета", Alert.AlertType.ERROR);
            }
        }
    }

    private void clearTable() {
        itemsView.getItems().clear();
    }

    private void handleEditItem(CommonItem item) {
        if (item != null) {
            boolean okClicked = mainApp.showItemEditDialog(item);
            if (okClicked) {
                itemsView.refresh();
                }
        }
    }

    private String getCurrentFolder() {
        final DirectoryChooser directoryChooser = new DirectoryChooser();
        File dir = directoryChooser.showDialog(new Stage());

        if (dir != null) {
            return dir.getAbsolutePath();
        }
        return null;
    }

    @FXML
    private void addProperty() {
//        AppProperties appProperties = new AppProperties();
//        appProperties.setProperties("name", "this is pattern");
    }

}
