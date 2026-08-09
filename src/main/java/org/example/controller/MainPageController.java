package org.example.controller;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.view.MainPage;
import org.example.view.SettingsPage;

import static org.example.view.Styles.*;

public class MainPageController {

    private Stage parentStage;
    private MainPage mainPage;

    private Stage settingsStage;
    private SettingsPageController settingsPageController;


    public MainPageController(Stage stage){

        this.parentStage = stage;
        mainPage = new MainPage();

        activeBtns();

        deactiveBtns();

        settingsBtn();

        exitBtn();
    }

    public MainPage getMainPage() {
        return mainPage;
    }

    public void activeBtns(){

        mainPage.getPlayBtn().setOnMouseEntered(e -> {
            mainPage.getPlayBtn().setStyle(BtnActiveStyle);
        });

        mainPage.getScoresBtn().setOnMouseEntered(e -> {
            mainPage.getScoresBtn().setStyle(BtnActiveStyle);
        });

        mainPage.getSettingsBtn().setOnMouseEntered(e -> {
            mainPage.getSettingsBtn().setStyle(BtnActiveStyle);
        });

        mainPage.getExitBtn().setOnMouseEntered(e -> {
            mainPage.getExitBtn().setStyle(BtnActiveStyle);
        });
    }

    public void deactiveBtns(){

        mainPage.getPlayBtn().setOnMouseExited(e -> {
            mainPage.getPlayBtn().setStyle(BtnNormalStyle);
        });

        mainPage.getScoresBtn().setOnMouseExited(e -> {
            mainPage.getScoresBtn().setStyle(BtnNormalStyle);
        });

        mainPage.getSettingsBtn().setOnMouseExited(e -> {
            mainPage.getSettingsBtn().setStyle(BtnNormalStyle);
        });

        mainPage.getExitBtn().setOnMouseExited(e -> {
            mainPage.getExitBtn().setStyle(BtnNormalStyle);
        });
    }

    public void settingsBtn(){
        mainPage.getSettingsBtn().setOnAction(e -> {
            openSttingsWindow();
        });
    }

    public void exitBtn(){
        mainPage.getExitBtn().setOnAction(e-> {
            Platform.exit();
        });
    }

    public void openSttingsWindow(){

        if (settingsStage == null){
            settingsStage = new Stage();
            settingsStage.initModality(Modality.APPLICATION_MODAL);
            settingsStage.initOwner(parentStage);
            settingsStage.initStyle(StageStyle.TRANSPARENT);
            settingsStage.setResizable(false);

            settingsPageController = new SettingsPageController(settingsStage);

            Scene scene = new Scene(settingsPageController.getSettingsPage());
            scene.setFill(Color.TRANSPARENT);
            settingsStage.setScene(scene);

        }

        settingsStage.showAndWait();
    }

    public void setMainPage(MainPage mainPage) {
        this.mainPage = mainPage;
    }
}
