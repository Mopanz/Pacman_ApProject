package org.example.controller;

import javafx.stage.Stage;
import org.example.util.AudioManager;
import org.example.view.SettingsPage;
import org.example.view.Styles;

import static org.example.view.Styles.BtnActiveStyle;

public class SettingsPageController {

    private SettingsPage settingsPage;

    public SettingsPageController(Stage settingsStage){

        settingsPage = new SettingsPage();

        activeBtns();

        deactiveBtns();

        closeBtn(settingsStage);

        soundBtn();

        musicBtn();

    }

    public void activeBtns(){

        settingsPage.getCloseBtn().setOnMouseEntered( e -> {
            settingsPage.getCloseBtn().setStyle(Styles.CloseActiveStyle);
        });

        settingsPage.getSoundBtn().setOnMouseEntered(e -> {
            if (AudioManager.getInstance().isSoundOn()){
                settingsPage.getSoundBtn().setStyle(Styles.BtnActiveStyle + Styles.SoundOnImg);
            }
            else {
                settingsPage.getSoundBtn().setStyle(Styles.BtnActiveStyle + Styles.SoundOffImg);
            }
        });

        settingsPage.getMusicBtn().setOnMouseEntered(e -> {
            if (AudioManager.getInstance().isMusicOn()){
                settingsPage.getMusicBtn().setStyle(Styles.BtnActiveStyle + Styles.MusicOnImg);
            }
            else {
                settingsPage.getMusicBtn().setStyle(Styles.BtnActiveStyle + Styles.MusicOffImg);
            }
        });

    }

    public void deactiveBtns(){

        settingsPage.getCloseBtn().setOnMouseExited( e -> {
            settingsPage.getCloseBtn().setStyle(Styles.CloseNormalStyle);
        });

        settingsPage.getSoundBtn().setOnMouseExited(e -> {
            if (AudioManager.getInstance().isSoundOn()){
                settingsPage.getSoundBtn().setStyle(Styles.BtnNormalStyle + Styles.SoundOnImg);
            }
            else {
                settingsPage.getSoundBtn().setStyle(Styles.BtnNormalStyle + Styles.SoundOffImg);
            }
        });

        settingsPage.getMusicBtn().setOnMouseExited(e -> {
            if (AudioManager.getInstance().isMusicOn()){
                settingsPage.getMusicBtn().setStyle(Styles.BtnNormalStyle + Styles.MusicOnImg);
            }
            else {
                settingsPage.getMusicBtn().setStyle(Styles.BtnNormalStyle + Styles.MusicOffImg);
            }
        });

    }

    public void closeBtn(Stage settingsStage){
        settingsPage.getCloseBtn().setOnAction( e -> {
            settingsStage.close();
        });
    }

    public void soundBtn(){
        settingsPage.getSoundBtn().setOnAction( e -> {
            if (AudioManager.getInstance().isSoundOn()){
                AudioManager.getInstance().offSound();
                settingsPage.getSoundBtn().setStyle(Styles.BtnActiveStyle + Styles.SoundOffImg);
            }
            else {
                AudioManager.getInstance().onSound();
                settingsPage.getSoundBtn().setStyle(Styles.BtnActiveStyle + Styles.SoundOnImg);
            }
        });
    }

    public void musicBtn(){
        settingsPage.getMusicBtn().setOnAction( e -> {
            if (AudioManager.getInstance().isMusicOn()){
                AudioManager.getInstance().offMusic();
                AudioManager.getInstance().pauseMainMusic();
                settingsPage.getMusicBtn().setStyle(Styles.BtnActiveStyle + Styles.MusicOffImg);
            }
            else {
                AudioManager.getInstance().onMusic();
                AudioManager.getInstance().playMainMusic();
                settingsPage.getMusicBtn().setStyle(Styles.BtnActiveStyle + Styles.MusicOnImg);
            }
        });
    }

    public SettingsPage getSettingsPage() {
        return settingsPage;
    }

    public void setSettingsPage(SettingsPage settingsPage) {
        this.settingsPage = settingsPage;
    }
}
