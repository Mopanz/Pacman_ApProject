package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.controller.MainPageController;
import org.example.view.MainPage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(new MainPageController().getMainPage()));
        stage.setWidth(550);
        stage.setHeight(650);
        stage.show();
    }
}
