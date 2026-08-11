package org.example.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import org.example.util.AudioManager;

public class SettingsPage extends VBox {

    private Button closeBtn;
    private Button soundBtn;
    private Button musicBtn;

    public SettingsPage(){

        closeBtn = new Button("X");
        closeBtn.setStyle(Styles.CloseNormalStyle);
        HBox top = new HBox(closeBtn);
        top.setAlignment(Pos.CENTER_RIGHT);

        soundBtn = new Button();
        if (AudioManager.getInstance().isSoundOn()){
            soundBtn.setStyle(Styles.BtnNormalStyle + Styles.SoundOnImg);
        }
        else {
            soundBtn.setStyle(Styles.BtnNormalStyle + Styles.SoundOffImg);
        }
        musicBtn = new Button();
        if (AudioManager.getInstance().isMusicOn()){
            musicBtn.setStyle(Styles.BtnNormalStyle + Styles.MusicOnImg);
        }
        else {
            musicBtn.setStyle(Styles.BtnNormalStyle + Styles.MusicOffImg);
        }
        VBox settingsColumn = new VBox(soundBtn, musicBtn);
        settingsColumn.setSpacing(20);
        settingsColumn.setAlignment(Pos.CENTER);

        this.setPrefSize(200, 200);
        this.setStyle(Styles.SmallWindowStyle);
        this.getChildren().addAll(top, settingsColumn);
    }

    public Button getCloseBtn() {
        return closeBtn;
    }

    public void setCloseBtn(Button closeBtn) {
        this.closeBtn = closeBtn;
    }

    public Button getSoundBtn() {
        return soundBtn;
    }

    public void setSoundBtn(Button soundBtn) {
        this.soundBtn = soundBtn;
    }

    public Button getMusicBtn() {
        return musicBtn;
    }

    public void setMusicBtn(Button musicBtn) {
        this.musicBtn = musicBtn;
    }
}
