package org.example.controller;

import org.example.view.GameView;

public class GameController {

    private GameView gameView;

    public GameController(){
        gameView = new GameView();
    }

    public GameView getGameView() {
        return gameView;
    }

    public void setGameView(GameView gameView) {
        this.gameView = gameView;
    }
}
