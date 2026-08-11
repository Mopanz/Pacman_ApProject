package org.example.controller;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.model.*;
import org.example.util.AudioManager;
import org.example.view.GamePage;
import org.example.view.GameView;

import java.util.ArrayList;

public class GameController {

    private Stage parentStage;
    private GamePage gamePage;
    private GameView gameView;
    private AnimationTimer timer;
    private Maze maze;
    private Pacman pacman;
    private ArrayList<Ghost> ghosts;
    private Direction nextDirection;
    private ScoreManager scoreManager;

    public GameController(Stage parentStage, int[][] levelGrid, boolean thirdGhost){
        this.parentStage = parentStage;
        gamePage = new GamePage(levelGrid, thirdGhost);
        gameView = gamePage.getGameView();
        maze = gameView.getMaze();
        pacman = new Pacman(23, 14);

        ghosts = new ArrayList<>();
        ghosts.add(new Ghost(15, 14, GhostColor.BLUE));
        ghosts.add(new Ghost(15, 13, GhostColor.ORANGE));
        if (thirdGhost){
            ghosts.add(new Ghost(14, 14, GhostColor.RED));
        }

        nextDirection = null;
        scoreManager = new ScoreManager();

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
            scoreManager.addMovePenalty();
        });
    }

    private void gameLoop(){
        timer = new AnimationTimer() {
            long last = 0;
            @Override
            public void handle(long now) {
                if (now - last > 150_000_000L){

                    movePacman();
                    moveGhost();

                    win();
                    gameOver();

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

            pacman.setPreviousRow(pacman.getRow());
            pacman.setPreviousColumn(pacman.getColumn());

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

    private void moveGhost(){
        AudioManager.getInstance().playGhostSound();

        for (Ghost ghost : ghosts){

            ghost.setPreviousRow(ghost.getRow());
            ghost.setPreviousColumn(ghost.getColumn());

            ghost.update(maze, pacman);

            switch (ghost.getDirection()) {
                case UP -> ghost.setRow(ghost.getRow() - 1);
                case DOWN -> ghost.setRow(ghost.getRow() + 1);
                case RIGHT -> ghost.setColumn(ghost.getColumn() + 1);
                case LEFT -> ghost.setColumn(ghost.getColumn() - 1);
            }
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

        for (int i=0; i<ghosts.size();i++){
            gameView.getGhostsImgView().get(i).setX(ghosts.get(i).getColumn() * GameObject.cellSize);
            gameView.getGhostsImgView().get(i).setY(ghosts.get(i).getRow() * GameObject.cellSize);
        }

        if (maze.getPelletAt(pacman.getRow(), pacman.getColumn()) != null && !maze.getPelletAt(pacman.getRow(), pacman.getColumn()).isEaten()){
            AudioManager.getInstance().playPelletSound();
            maze.getPelletAt(pacman.getRow(), pacman.getColumn()).eat();
            gameView.getChildren().remove(gameView.getPelletsImg().get(maze.getPelletAt(pacman.getRow(), pacman.getColumn())));
            scoreManager.addPelletScore();
        }

        gamePage.updateScore(scoreManager);

    }

    private void win(){
        if (maze.areAllPelletsEaten()){
            timer.stop();
            AudioManager.getInstance().pauseGhostSound();
            gameView.pausePacmanAnimation();
            System.out.println("Win\nScore:" + scoreManager.getScore());
        }
    }

    private void gameOver(){
        for (Ghost ghost : ghosts){
            boolean conditionOne = ghost.getRow() == pacman.getRow() && ghost.getColumn() == pacman.getColumn();
            boolean conditionTwo = ghost.getRow() == pacman.getPreviousRow() && ghost.getColumn() == pacman.getPreviousColumn() && ghost.getPreviousRow() == pacman.getRow() && ghost.getPreviousColumn() == pacman.getColumn();
            if (conditionOne || conditionTwo){
                timer.stop();
                AudioManager.getInstance().pauseGhostSound();
                gameView.pausePacmanAnimation();
                Platform.runLater(() -> oppenGameOverWindow());
                break;
            }
        }
    }

    private void oppenGameOverWindow(){
        Stage gameOverStage = new Stage();
        gameOverStage.initModality(Modality.APPLICATION_MODAL);
        gameOverStage.initOwner(parentStage);
        gameOverStage.initStyle(StageStyle.TRANSPARENT);
        gameOverStage.setResizable(false);

        GameOverPageController gameOverPageController= new GameOverPageController(gameOverStage, parentStage, scoreManager.getScore(), maze.getGrid(), ghosts.size() == 3);

        Scene scene = new Scene(gameOverPageController.getGameOverPage());
        scene.setFill(Color.TRANSPARENT);
        gameOverStage.setScene(scene);

        gameOverStage.showAndWait();
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

    public GamePage getGamePage() {
        return gamePage;
    }

    public void setGamePage(GamePage gamePage) {
        this.gamePage = gamePage;
    }

    public Direction getNextDirection() {
        return nextDirection;
    }

    public void setNextDirection(Direction nextDirection) {
        this.nextDirection = nextDirection;
    }
}
