package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import logic.format.FormatText;
import logic.model.Author;
import logic.model.CommonItem;

public class MainController {

    @FXML
    private Button add_item_button;

//    @FXML
//    private ChoiceBox<String> source_view_choice_box;

    @FXML
    private ListView<CommonItem> itemsView = new ListView<>();

    FormatText format = new FormatText();

    @FXML
    private void initialize() {
        //перенести в базу данных
//        ObservableList<String> sourceViews = FXCollections.observableArrayList("Журнальные статьи",
//                "Монографии", "Авторефераты", "Диссертации", "Обзоры (аналитика)", "Патенты", "Материалы конференций",
//                "Интернет-документы", "Учебники", "Учебные пособия", "Словари");
//
//        source_view_choice_box.setItems(sourceViews);
//        source_view_choice_box.getSelectionModel().selectFirst();

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
            }
        });

    }

    @FXML
    private void addNewItem(ActionEvent event) {

        Author author = new Author("Иванов", "Василий", "Петрович");
        Author author1 = new Author("Васильев", "Геннадий", "Александович");
        Author author2 = new Author("Коновалов", "Григорий", "Александович");
        Author author3 = new Author("Александров", "Виталий", "Владимирович");

        CommonItem item = new CommonItem(author, "тестовая статья", "сделайСам",
                "Астрахань", 1990, 302, "Учебники");

        item.setAuthor(author);

        item.setToAuthors(author1);
        item.setToAuthors(author2);
        item.setToAuthors(author3);

        itemsView.getItems().add(item);

        Edit editWindow = new Edit();
        editWindow.getNewEditWindow();

    }




}
