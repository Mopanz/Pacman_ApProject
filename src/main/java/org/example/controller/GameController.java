package org.example.controller;

import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import org.example.model.Direction;
import org.example.model.GameObject;
import org.example.model.Maze;
import org.example.model.Pacman;
import org.example.view.GameView;

public class GameController {

    private GameView gameView;
    private Maze maze;
    private Pacman pacman;
    private Direction nextDirection;

    public GameController(){
        gameView = new GameView();
        maze = gameView.getMaze();
        pacman = new Pacman(23, 14);
        nextDirection = null;

        gameView.getPacmanImgView().setFocusTraversable(true);
        gameView.getPacmanImgView().requestFocus();

        setMoveDirection();

        gameLoop();
    }

    public void setMoveDirection(){
        gameView.setOnKeyPressed(e -> {
            switch (e.getCode()){
                case KeyCode.UP -> nextDirection = Direction.UP;
                case KeyCode.DOWN -> nextDirection = Direction.DOWN;
                case KeyCode.RIGHT -> nextDirection = Direction.RIGHT;
                case KeyCode.LEFT -> nextDirection = Direction.LEFT;
            }
        });
    }

    private void gameLoop(){
        AnimationTimer timer = new AnimationTimer() {
            long last = 0;
            @Override
            public void handle(long now) {
                if (now - last > 150_000_000L){

                    movePacman();

                    last = now;

                }
            }
        };
        timer.start();
    }

    private void movePacman(){
        if (pacman.canMove(maze, nextDirection)){
            pacman.setDirection(nextDirection);
        }

        if (pacman.canMove(maze, pacman.getDirection())){

            switch (pacman.getDirection()){
                case UP -> pacman.setRow(pacman.getRow() - 1);
                case DOWN -> pacman.setRow(pacman.getRow() + 1);
                case RIGHT -> pacman.setColumn(pacman.getColumn() + 1);
                case LEFT -> pacman.setColumn(pacman.getColumn() - 1);
            }
            pacman.setMoving(true);
            updatePacmanImgDirection(pacman.getDirection());
        }
        else {
            pacman.setMoving(false);
        }
        updateView();
    }

    private void updatePacmanImgDirection(Direction direction){
        switch (direction){
            case UP -> gameView.getPacmanImgView().setRotate(270);
            case DOWN -> gameView.getPacmanImgView().setRotate(90);
            case RIGHT -> gameView.getPacmanImgView().setRotate(0);
            case LEFT -> gameView.getPacmanImgView().setRotate(180);
        }
    }

    private void updateView(){
        if (pacman.isMoving()){
            gameView.playPacmanAnimation();
            gameView.getPacmanImgView().setX(pacman.getColumn() * GameObject.cellSize);
            gameView.getPacmanImgView().setY(pacman.getRow() * GameObject.cellSize);
        }
        else {
            gameView.pausePacmanAnimation();
        }

    }

    public GameView getGameView() {
        return gameView;
    }

    public void setGameView(GameView gameView) {
        this.gameView = gameView;
    }

    public Maze getMaze() {
        return maze;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    public Pacman getPacman() {
        return pacman;
    }

    public void setPacman(Pacman pacman) {
        this.pacman = pacman;
    }
}
