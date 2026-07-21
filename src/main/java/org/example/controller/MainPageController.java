package org.example.controller;

import org.example.view.MainPage;

import static org.example.view.Styles.*;

public class MainPageController {
    private MainPage mainPage;

    public MainPageController(){

        mainPage = new MainPage();

        activeBtns();

        deactiveBtns();
    }

    public MainPage getMainPage() {
        return mainPage;
    }

    public void activeBtns(){

        mainPage.getPlayBtn().setOnMouseEntered(e -> {
            mainPage.getPlayBtn().setStyle(activeStyle);
        });

        mainPage.getScoresBtn().setOnMouseEntered(e -> {
            mainPage.getScoresBtn().setStyle(activeStyle);
        });

        mainPage.getSettingsBtn().setOnMouseEntered(e -> {
            mainPage.getSettingsBtn().setStyle(activeStyle);
        });

        mainPage.getExitBtn().setOnMouseEntered(e -> {
            mainPage.getExitBtn().setStyle(activeStyle);
        });
    }

    public void deactiveBtns(){

        mainPage.getPlayBtn().setOnMouseExited(e -> {
            mainPage.getPlayBtn().setStyle(normalStyle);
        });

        mainPage.getScoresBtn().setOnMouseExited(e -> {
            mainPage.getScoresBtn().setStyle(normalStyle);
        });

        mainPage.getSettingsBtn().setOnMouseExited(e -> {
            mainPage.getSettingsBtn().setStyle(normalStyle);
        });

        mainPage.getExitBtn().setOnMouseExited(e -> {
            mainPage.getExitBtn().setStyle(normalStyle);
        });
    }

    public void setMainPage(MainPage mainPage) {
        this.mainPage = mainPage;
    }
}
