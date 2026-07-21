package org.example.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import static org.example.view.Styles.*;

public class MainPage extends StackPane {

    private ImageView bg;
    private ImageView logo;
    private Button playBtn;
    private Button scoresBtn;
    private Button settingsBtn;
    private Button exitBtn;

    public MainPage(){
        bg = new ImageView(new Image(getClass().getResourceAsStream("/Images/MainPageBackground.jpg")));
        bg.fitWidthProperty().bind(this.widthProperty());
        bg.fitHeightProperty().bind(this.heightProperty());
        bg.setPreserveRatio(false);

        logo = new ImageView(new Image(getClass().getResourceAsStream("/Images/MainPageLogo.png")));
        logo.setFitWidth(500);
        logo.setPreserveRatio(true);

        playBtn = new Button("Play");
        playBtn.setStyle(normalStyle);
        scoresBtn = new Button("Scores");
        scoresBtn.setStyle(normalStyle);
        settingsBtn = new Button("Settings");
        settingsBtn.setStyle(normalStyle);
        exitBtn = new Button("Exit");
        exitBtn.setStyle(normalStyle);

        VBox menu = new VBox(20);
        menu.setAlignment(Pos.CENTER);
        menu.setPadding(new Insets(40, 50, 50, 50));
        menu.getChildren().addAll(logo, new Region(), playBtn, scoresBtn, settingsBtn,exitBtn);
        menu.setMaxWidth(400);

        this.getChildren().addAll(bg, menu);
    }

    public ImageView getBg() {
        return bg;
    }

    public void setBg(ImageView bg) {
        this.bg = bg;
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
