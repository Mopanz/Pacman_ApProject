package org.example.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.example.util.AudioManager;

public class VictoryPage extends VBox {

    private Button playAgainBtn;
    private Button backToMenuBtn;

    public VictoryPage(int score){

        AudioManager.getInstance().playVictorySound();

        Label titleLabel = new Label("VICTORY");
        titleLabel.setStyle(Styles.ScoreStyle);

        Label scoreLabel = new Label("Score: " + score);
        scoreLabel.setStyle(Styles.ScoreStyle + "-fx-text-fill: #000000");

        playAgainBtn = new Button("Play again");
        playAgainBtn.setStyle(Styles.BtnNormalStyle);

        backToMenuBtn = new Button("Back to menu");
        backToMenuBtn.setStyle(Styles.BtnNormalStyle);

        this.setStyle(Styles.SmallWindowStyle);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.getChildren().addAll(titleLabel, scoreLabel, playAgainBtn, backToMenuBtn);
        this.setPrefSize(250, 300);
    }

    public Button getPlayAgainBtn() {
        return playAgainBtn;
    }

    public void setPlayAgainBtn(Button playAgainBtn) {
        this.playAgainBtn = playAgainBtn;
    }

    public Button getBackToMenuBtn() {
        return backToMenuBtn;
    }

    public void setBackToMenuBtn(Button backToMenuBtn) {
        this.backToMenuBtn = backToMenuBtn;
    }

}
