package org.example.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import org.example.util.AudioManager;

import static org.example.view.Styles.*;

public class MainPage extends VBox {

    private ImageView logo;
    private Button playBtn;
    private Button scoresBtn;
    private Button settingsBtn;
    private Button exitBtn;

    public MainPage(){

        AudioManager.getInstance().playMainMusic();

        logo = new ImageView(new Image(getClass().getResourceAsStream("/Images/MainPageLogo.png")));
        logo.setFitWidth(500);
        logo.setPreserveRatio(true);

        playBtn = new Button("Play");
        playBtn.setStyle(BtnNormalStyle);
        scoresBtn = new Button("Scores");
        scoresBtn.setStyle(BtnNormalStyle);
        settingsBtn = new Button("Settings");
        settingsBtn.setStyle(BtnNormalStyle);
        exitBtn = new Button("Exit");
        exitBtn.setStyle(BtnNormalStyle);

        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: #1d5397;");
        this.setPadding(new Insets(40, 50, 50, 50));
        this.getChildren().addAll(logo, new Region(), playBtn, scoresBtn, settingsBtn,exitBtn);
        this.setMaxWidth(400);

    }

    public ImageView getLogo() {
        return logo;
    }

    public void setLogo(ImageView logo) {
        this.logo = logo;
    }

    public Button getPlayBtn() {
        return playBtn;
    }

    public void setPlayBtn(Button playBtn) {
        this.playBtn = playBtn;
    }

    public Button getScoresBtn() {
        return scoresBtn;
    }

    public void setScoresBtn(Button scoresBtn) {
        this.scoresBtn = scoresBtn;
    }

    public Button getSettingsBtn() {
        return settingsBtn;
    }

    public void setSettingsBtn(Button settingsBtn) {
        this.settingsBtn = settingsBtn;
    }

    public Button getExitBtn() {
        return exitBtn;
    }

    public void setExitBtn(Button exitBtn) {
        this.exitBtn = exitBtn;
    }
}
