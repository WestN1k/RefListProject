package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logic.model.Author;
import logic.model.CommonItem;
import ui.controllers.AuthorController;
import ui.controllers.EditController;
import ui.controllers.MainController;

import java.io.IOException;

public class Main extends Application {

    private Stage rootStage;

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
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.rootStage);
            dialogStage.setScene(new Scene(page));

            // Передаём адресата в контроллер.
            EditController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setCommonItem(item);

            // Отображаем диалоговое окно и ждём, пока пользователь его не закроет
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean showAuthorEditDialog(CommonItem item) {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/fxml/edit.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Author");
            dialogStage.initModality(Modality.WINDOW_MODAL);
//            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Передаём адресата в контроллер.
            AuthorController controller = loader.getController();
//        controller.setAuthorDialogStage(dialogStage);
//        controller.setAuthor(item.getAuthor());

            dialogStage.showAndWait();
//            return controller.isOkClicked();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}