package ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import logic.format.FormatText;
import logic.model.Author;
import logic.model.CommonItem;
import ui.Main;

public class MainController {

    @FXML
    private Button add_item_button;

    @FXML
    private ListView<CommonItem> itemsView = new ListView<>();

    private Main mainApp;

    FormatText format = new FormatText();


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
                if(empty || item == null || item.getName() == null){
                    setText("");
                } else {
                    setText(format.getFormatTextManual(item));
                }
            }
        });

        itemsView.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                System.out.println(itemsView.getSelectionModel().getSelectedItem());

                //как передать данные на страницу edit для редактирования???
                handleEditItem(itemsView.getSelectionModel().getSelectedItem());
            }
        });

    }

    @FXML
    private void addNewItem(ActionEvent event) {

//        Author author = new Author("Иванов", "Василий", "Петрович");
//        Author author1 = new Author("Васильев", "Геннадий", "Александович");
//        Author author2 = new Author("Коновалов", "Григорий", "Александович");
//        Author author3 = new Author("Александров", "Виталий", "Владимирович");
//
//        CommonItem item = new CommonItem(author, "тестовая статья", "сделайСам",
//                "Астрахань", 1990, 302, "Учебники");
//
//        item.setAuthor(author);
//
//        item.setToAuthors(author1);
//        item.setToAuthors(author2);
//        item.setToAuthors(author3);
//
//        itemsView.getItems().add(item);
//        mainApp.showAuthorEditDialog()
//        Edit editWindow = new Edit();
//        editWindow.getNewEditWindow();

        handleNewItem();
    }

    public void handleNewItem() {
        CommonItem tempItem = new CommonItem();
        boolean okClicked = mainApp.showItemEditDialog(tempItem);
        if (okClicked) {
            itemsView.getItems().add(tempItem);
        }
    }

    private void handleEditItem(CommonItem item) {
        if (item != null) {
            boolean okClicked = mainApp.showItemEditDialog(item);
//            if (okClicked) {
//                showPersonDetails(selectedPerson);
//                }
        }
    }

}
