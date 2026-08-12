package org.example.controller;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.example.database.DatabaseManager;
import org.example.view.Styles;
import org.example.view.TopScoresPage;

import java.util.ArrayList;

public class TopScorePageController {

    private TopScoresPage topScoresPage;

    public TopScorePageController(Stage scoreStage){

        topScoresPage = new TopScoresPage();

        activeBtns();

        deactiveBtns();

        closeBtn(scoreStage);

        getTwoGhostClassicMapScores();

        getTwoGhostHardMapScores();

        getThreeGhostClassicMapScores();

        getThreeGhostHardMapScores();
    }

    public void activeBtns(){

        topScoresPage.getCloseBtn().setOnMouseEntered( e -> {
            topScoresPage.getCloseBtn().setStyle(Styles.CloseActiveStyle);
        });

    }

    public void deactiveBtns(){

        topScoresPage.getCloseBtn().setOnMouseExited( e -> {
            topScoresPage.getCloseBtn().setStyle(Styles.CloseNormalStyle);
        });

    }

    public void closeBtn(Stage scoreStage){

        topScoresPage.getCloseBtn().setOnAction( e -> {
            scoreStage.close();
        });

    }

    private void getTwoGhostClassicMapScores(){
        ArrayList<Integer> topScores = DatabaseManager.getTopScores(2, "Classic");
        if (topScores.size() == 0){
            Label emptyLabel = new Label("Empty!");
            emptyLabel.setAlignment(Pos.CENTER);
            emptyLabel.setStyle(Styles.ScoreStyle + "-fx-text-fill: #000000");
            topScoresPage.getvBoxTwoGhostClassicMap().getChildren().add(emptyLabel);
        }
        else {
            for (int i = 0; i < topScores.size(); i++){
                Label scoreLabel = new Label(i+1 + ": " + topScores.get(i));
                scoreLabel.setAlignment(Pos.CENTER);
                scoreLabel.setStyle(Styles.ScoreStyle + "-fx-text-fill: #000000");
                topScoresPage.getvBoxTwoGhostClassicMap().getChildren().add(scoreLabel);
            }
        }
    }

    private void getTwoGhostHardMapScores(){
        ArrayList<Integer> topScores = DatabaseManager.getTopScores(2, "Hard");
        if (topScores.size() == 0){
            Label emptyLabel = new Label("Empty!");
            emptyLabel.setAlignment(Pos.CENTER);
            emptyLabel.setStyle(Styles.ScoreStyle + "-fx-text-fill: #000000");
            topScoresPage.getvBoxTwoGhostHardMap().getChildren().add(emptyLabel);
        }
        else {
            for (int i = 0; i < topScores.size(); i++){
                Label scoreLabel = new Label(i+1 + ": " + topScores.get(i));
                scoreLabel.setAlignment(Pos.CENTER);
                scoreLabel.setStyle(Styles.ScoreStyle + "-fx-text-fill: #000000");
                topScoresPage.getvBoxTwoGhostHardMap().getChildren().add(scoreLabel);
            }
        }
    }

    private void getThreeGhostClassicMapScores(){
        ArrayList<Integer> topScores = DatabaseManager.getTopScores(3, "Classic");
        if (topScores.size() == 0){
            Label emptyLabel = new Label("Empty!");
            emptyLabel.setAlignment(Pos.CENTER);
            emptyLabel.setStyle(Styles.ScoreStyle + "-fx-text-fill: #000000");
            topScoresPage.getvBoxThreeGhostClassicMap().getChildren().add(emptyLabel);
        }
        else {
            for (int i = 0; i < topScores.size(); i++){
                Label scoreLabel = new Label(i+1 + ": " + topScores.get(i));
                scoreLabel.setAlignment(Pos.CENTER);
                scoreLabel.setStyle(Styles.ScoreStyle + "-fx-text-fill: #000000");
                topScoresPage.getvBoxThreeGhostClassicMap().getChildren().add(scoreLabel);
            }
        }
    }

    private void getThreeGhostHardMapScores(){
        ArrayList<Integer> topScores = DatabaseManager.getTopScores(3, "Hard");
        if (topScores.size() == 0){
            Label emptyLabel = new Label("Empty!");
            emptyLabel.setAlignment(Pos.CENTER);
            emptyLabel.setStyle(Styles.ScoreStyle + "-fx-text-fill: #000000");
            topScoresPage.getvBoxThreeGhostHardMap().getChildren().add(emptyLabel);
        }
        else {
            for (int i = 0; i < topScores.size(); i++){
                Label scoreLabel = new Label(i+1 + ": " + topScores.get(i));
                scoreLabel.setAlignment(Pos.CENTER);
                scoreLabel.setStyle(Styles.ScoreStyle + "-fx-text-fill: #000000");
                topScoresPage.getvBoxThreeGhostHardMap().getChildren().add(scoreLabel);
            }
        }
    }

    public TopScoresPage getTopScoresPage() {
        return topScoresPage;
    }

    public void setTopScoresPage(TopScoresPage topScoresPage) {
        this.topScoresPage = topScoresPage;
    }
}
