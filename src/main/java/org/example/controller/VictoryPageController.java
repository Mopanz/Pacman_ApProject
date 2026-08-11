package org.example.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.view.Styles;
import org.example.view.VictoryPage;

public class VictoryPageController {

    private VictoryPage victoryPage;

    public VictoryPageController(Stage victoryStage, Stage parentStage, int score, int[][] LevelsGrid, boolean thirdGhost){

        victoryPage = new VictoryPage(score);

        activeBtns();

        deactiveBtns();

        playAgainBtn(victoryStage, parentStage, LevelsGrid, thirdGhost);

        backToMenuBtn(victoryStage, parentStage);

    }

    public void activeBtns(){

        victoryPage.getPlayAgainBtn().setOnMouseEntered(e -> {
            victoryPage.getPlayAgainBtn().setStyle(Styles.BtnActiveStyle);
        });

        victoryPage.getBackToMenuBtn().setOnMouseEntered( e -> {
            victoryPage.getBackToMenuBtn().setStyle(Styles.BtnActiveStyle);
        });

    }

    public void deactiveBtns(){

        victoryPage.getPlayAgainBtn().setOnMouseExited( e -> {
            victoryPage.getPlayAgainBtn().setStyle(Styles.BtnNormalStyle);
        });

        victoryPage.getBackToMenuBtn().setOnMouseExited( e -> {
            victoryPage.getBackToMenuBtn().setStyle(Styles.BtnNormalStyle);
        });

    }

    public void playAgainBtn(Stage victoryStage, Stage parentStage, int[][] levelsGrid, boolean thirdGhost){
        victoryPage.getPlayAgainBtn().setOnAction( e -> {
            victoryStage.close();
            GameController gameController = new GameController(parentStage, levelsGrid, thirdGhost);
            parentStage.setScene(new Scene(gameController.getGamePage()));
        });
    }

    public void backToMenuBtn(Stage victoryStage, Stage parentStage){
        victoryPage.getBackToMenuBtn().setOnAction( e -> {
            victoryStage.close();
            parentStage.setScene(new Scene(new MainPageController(parentStage).getMainPage()));
        });
    }

    public VictoryPage getVictoryPage() {
        return victoryPage;
    }

    public void setVictoryPage(VictoryPage victoryPage) {
        this.victoryPage = victoryPage;
    }
}
