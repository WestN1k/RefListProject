package com.yamanov.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.yamanov.logic.model.Author;
import com.yamanov.logic.model.CommonItem;
import com.yamanov.ui.controllers.AuthorController;
import com.yamanov.ui.controllers.EditController;
import com.yamanov.ui.controllers.MainController;

import java.io.IOException;

public class Main extends Application {

    private Stage rootStage;
    private Stage editStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.rootStage = stage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        Parent root = loader.load();
        this.rootStage.setTitle("Составление списка литературы по ГОСТ");
        root.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
        MainController controller = loader.getController();
        controller.setMainApp(this);

        this.rootStage.setScene(new Scene(root));
        this.rootStage.show();
    }

    @Override
    public void init() throws Exception {
        System.out.println("Application inits");
        super.init();
    }

    public boolean showItemEditDialog(CommonItem item) {
        try {
            // Загружаем fxml-файл и создаём новую сцену
            // для всплывающего диалогового окна.
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/edit.fxml"));
            AnchorPane page = loader.load();

            // Создаём диалоговое окно Stage.
            editStage = new Stage();
            editStage.setTitle("Edit Person");
            editStage.initModality(Modality.WINDOW_MODAL);
            editStage.initOwner(this.rootStage);
            editStage.setScene(new Scene(page));

            // Передаём адресата в контроллер.
            EditController controller = loader.getController();
            controller.setDialogStage(editStage);
            controller.setCommonItem(item);
            controller.setMainApp(this);

            // Отображаем диалоговое окно и ждём, пока пользователь его не закроет
            editStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean showAuthorEditDialog(Author author) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/author.fxml"));
            AnchorPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Author");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.editStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Передаём адресата в контроллер.
            AuthorController controller = loader.getController();
            controller.setAuthorDialogStage(dialogStage);

            controller.setAuthor(author);

            dialogStage.showAndWait();
//            return controller.isOkClicked();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}