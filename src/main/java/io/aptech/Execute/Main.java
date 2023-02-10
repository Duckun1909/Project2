package io.aptech.Execute;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/Views/Menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 780, 640);
       //scene.getStylesheets().add(getClass().getResource("aplication.css").toExternalForm());
        stage.setTitle("Shopping online management");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}