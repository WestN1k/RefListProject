package ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import logic.model.CommonItem;

import java.io.IOException;

public class EditController {

    @FXML
    private ChoiceBox<String> source_view_choice_box;

    @FXML
    private Pane EditContentPane;

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
        setEditContentPane(FXMLLoader.load(getClass().getResource("/fxml/editTypes/manual.fxml")));
    }

    public void loadMonographPane() throws IOException {
        setEditContentPane(FXMLLoader.load(getClass().getResource("/fxml/editTypes/monography.fxml")));
    }

    public void setRedactItem(CommonItem item) {

    }

    public void getItemToChoice(CommonItem item) {
        switchChoiceValue(item.getItemType());
        System.out.println(item.getName());
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
}
