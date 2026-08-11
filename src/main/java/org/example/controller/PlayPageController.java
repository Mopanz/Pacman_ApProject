package org.example.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.model.LevelsGrid;
import org.example.util.AudioManager;
import org.example.view.PlayPage;
import org.example.view.Styles;

public class PlayPageController {

    private PlayPage playPage;

    public PlayPageController(Stage playStage, Stage parentStage){

        playPage = new PlayPage();

        activeBtns();

        deactiveBtns();

        closeBtn(playStage);

        ghostRadioButtons();

        mapRadioButtons();

        startBtn(playStage, parentStage);

    }

    public void activeBtns(){

        playPage.getCloseBtn().setOnMouseEntered( e -> {
            playPage.getCloseBtn().setStyle(Styles.CloseActiveStyle);
        });

        playPage.getStartBtn().setOnMouseEntered( e -> {
            playPage.getStartBtn().setStyle(Styles.BtnActiveStyle);
        });

    }

    public void deactiveBtns(){

        playPage.getCloseBtn().setOnMouseExited( e -> {
            playPage.getCloseBtn().setStyle(Styles.CloseNormalStyle);
        });

        playPage.getStartBtn().setOnMouseExited( e -> {
            playPage.getStartBtn().setStyle(Styles.BtnNormalStyle);
        });

    }

    public void closeBtn(Stage playStage){
        playPage.getCloseBtn().setOnAction( e -> {
            playStage.close();
        });
    }

    public void ghostRadioButtons(){

        playPage.getTwoGhost().selectedProperty().addListener(
                (obs, oldValue, newValue) -> {
                    if (newValue){
                        playPage.getTwoGhost().setStyle(Styles.BtnActiveStyle + Styles.TwoGhostsImg);
                    }
                    else {
                        playPage.getTwoGhost().setStyle(Styles.BtnNormalStyle + Styles.TwoGhostsImg);
                    }
                }
        );

        playPage.getThreeGhost().selectedProperty().addListener(
                (obs, oldValue, newValue) -> {
                    if (newValue){
                        playPage.getThreeGhost().setStyle(Styles.BtnActiveStyle + Styles.ThreeGhostsImg);
                    }
                    else {
                        playPage.getThreeGhost().setStyle(Styles.BtnNormalStyle + Styles.ThreeGhostsImg);
                    }
                }
        );

    }

    public void mapRadioButtons(){

        playPage.getClassicMap().selectedProperty().addListener(
                (obs, oldValue, newValue) -> {
                    if (newValue){
                        playPage.getClassicMap().setStyle(Styles.BtnActiveStyle + Styles.ClassicMapImg);
                    }
                    else {
                        playPage.getClassicMap().setStyle(Styles.BtnNormalStyle + Styles.ClassicMapImg);
                    }
                }
        );

        playPage.getHardMap().selectedProperty().addListener(
                (obs, oldValue, newValue) -> {
                    if (newValue){
                        playPage.getHardMap().setStyle(Styles.BtnActiveStyle + Styles.HardMapImg);
                    }
                    else {
                        playPage.getHardMap().setStyle(Styles.BtnNormalStyle + Styles.HardMapImg);
                    }
                }
        );

    }

    public void startBtn(Stage playStage, Stage parentStage){
        playPage.getStartBtn().setOnAction( e -> {
            playStage.close();
            AudioManager.getInstance().stopMainMusic();

            GameController gameController;
            if (playPage.getClassicMap().isSelected()){
                gameController = new GameController(parentStage, LevelsGrid.getLevel1(), playPage.getThreeGhost().isSelected());
            }
            else {
                gameController = new GameController(parentStage, LevelsGrid.getLevel2(), playPage.getThreeGhost().isSelected());
            }
            parentStage.setScene(new Scene(gameController.getGamePage()));
        });
    }

    public PlayPage getPlayPage() {
        return playPage;
    }

    public void setPlayPage(PlayPage playPage) {
        this.playPage = playPage;
    }
}
