package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        stage.setTitle("Составление списка литературы по ГОСТ");
        root.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Override
    public void init() throws Exception {
        System.out.println("Application inits");
        super.init();
    }
}