package org.example.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.example.model.ScoreManager;

public class GamePage extends VBox {

    private Label scoreLabel;
    private GameView gameView;

    public GamePage(int[][] levelGrid, boolean thirdGhost){

        scoreLabel = new Label("SCORE : 0");
        scoreLabel.setStyle(Styles.ScoreStyle);

        gameView = new GameView(levelGrid, thirdGhost);

        this.getChildren().addAll(scoreLabel, gameView);
        this.setStyle("-fx-background-color: black;");
        this.setAlignment(Pos.TOP_CENTER);

    }

    public void updateScore(ScoreManager scoreManager){
        scoreLabel.setText("SCORE : " + scoreManager.getScore());
    }

    public Label getScoreLabel() {
        return scoreLabel;
    }

    public void setScoreLabel(Label scoreLabel) {
        this.scoreLabel = scoreLabel;
    }

    public GameView getGameView() {
        return gameView;
    }

    public void setGameView(GameView gameView) {
        this.gameView = gameView;
    }
}
