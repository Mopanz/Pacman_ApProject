package org.example.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.model.LevelsGrid;
import org.example.view.GameOverPage;
import org.example.view.Styles;

public class GameOverPageController {

    private GameOverPage gameOverPage;

    public GameOverPageController(Stage gameOverStage, Stage parentStage, int score, int[][] LevelsGrid, boolean thirdGhost){

        gameOverPage = new GameOverPage(score);

        activeBtns();

        deactiveBtns();

        playAgainBtn(gameOverStage, parentStage, LevelsGrid, thirdGhost);

        backToMenuBtn(gameOverStage, parentStage);

    }

    public void activeBtns(){

        gameOverPage.getPlayAgainBtn().setOnMouseEntered(e -> {
            gameOverPage.getPlayAgainBtn().setStyle(Styles.BtnActiveStyle);
        });

        gameOverPage.getBackToMenuBtn().setOnMouseEntered( e -> {
            gameOverPage.getBackToMenuBtn().setStyle(Styles.BtnActiveStyle);
        });

    }

    public void deactiveBtns(){

        gameOverPage.getPlayAgainBtn().setOnMouseExited( e -> {
            gameOverPage.getPlayAgainBtn().setStyle(Styles.BtnNormalStyle);
        });

        gameOverPage.getBackToMenuBtn().setOnMouseExited( e -> {
            gameOverPage.getBackToMenuBtn().setStyle(Styles.BtnNormalStyle);
        });

    }

    public void playAgainBtn(Stage gameOverStage, Stage parentStage, int[][] levelsGrid, boolean thirdGhost){
        gameOverPage.getPlayAgainBtn().setOnAction( e -> {
            gameOverStage.close();
            GameController gameController = new GameController(parentStage, levelsGrid, thirdGhost);
            parentStage.setScene(new Scene(gameController.getGamePage()));
        });
    }

    public void backToMenuBtn(Stage gameOverStage, Stage parentStage){
        gameOverPage.getBackToMenuBtn().setOnAction( e -> {
            gameOverStage.close();
            parentStage.setScene(new Scene(new MainPageController(parentStage).getMainPage()));
        });
    }

    public GameOverPage getGameOverPage() {
        return gameOverPage;
    }

    public void setGameOverPage(GameOverPage gameOverPage) {
        this.gameOverPage = gameOverPage;
    }
}
