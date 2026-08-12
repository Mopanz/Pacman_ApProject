package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.example.controller.GameController;
import org.example.controller.MainPageController;
import org.example.database.DatabaseManager;
import org.example.view.MainPage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(new MainPageController(stage).getMainPage()));
        stage.setWidth(575);
        stage.setHeight(710);
        stage.setResizable(false);
        stage.setTitle("Pac-Man");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/Images/Icon.png")));
        stage.show();
    }
}
