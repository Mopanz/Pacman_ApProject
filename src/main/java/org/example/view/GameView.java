package org.example.view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import org.example.model.GameObject;
import org.example.model.LevelsGrid;
import org.example.model.Maze;

public class GameView extends Pane {

    private Maze maze;
    private ImageView pacmanImgView;
    private Timeline pacmanAnimation;

    public GameView(){

        maze = new Maze(LevelsGrid.getLevel1());

        this.setStyle("-fx-background-color: black;");
        this.setPrefSize(maze.getColumns() * GameObject.cellSize, maze.getRows() * GameObject.cellSize);

        drawMaze();

        creatPacman();
    }

    private void drawMaze(){

        Image pelletImg = new Image(getClass().getResourceAsStream("/Images/Pellet.png"));
        Image wallImg = new Image(getClass().getResourceAsStream("/Images/WallBlock.png"));

        for (int i=0; i<maze.getRows(); i++){
            for (int j=0; j<maze.getColumns(); j++){
                if (maze.getGrid()[i][j] == 0) {
                    ImageView pelletImgView = new ImageView(pelletImg);
                    pelletImgView.setY(i * GameObject.cellSize);
                    pelletImgView.setX(j * GameObject.cellSize);
                    this.getChildren().add(pelletImgView);
                }
                else if (maze.getGrid()[i][j] == 1) {
                    ImageView wallImgView = new ImageView(wallImg);
                    wallImgView.setY(i * GameObject.cellSize);
                    wallImgView.setX(j * GameObject.cellSize);
                    this.getChildren().add(wallImgView);
                }
            }
        }
    }

    public void creatPacman(){
        Image pacmanImg1 = new Image(getClass().getResourceAsStream("/Images/Pacman1.png"));
        Image pacmanImg2 = new Image(getClass().getResourceAsStream("/Images/Pacman2.png"));
        Image pacmanImg3 = new Image(getClass().getResourceAsStream("/Images/Pacman3.png"));

        pacmanImgView = new ImageView(pacmanImg1);
        pacmanImgView.setX(14 * GameObject.cellSize);
        pacmanImgView.setY(23 * GameObject.cellSize);

        KeyFrame frame1 = new KeyFrame(Duration.millis(150), e -> pacmanImgView.setImage(pacmanImg1));
        KeyFrame frame2 = new KeyFrame(Duration.millis(300), e -> pacmanImgView.setImage(pacmanImg2));
        KeyFrame frame3 = new KeyFrame(Duration.millis(450), e -> pacmanImgView.setImage(pacmanImg3));
        KeyFrame frame4 = new KeyFrame(Duration.millis(600), e -> pacmanImgView.setImage(pacmanImg2));
        pacmanAnimation = new Timeline(frame1, frame2, frame3, frame4);
        pacmanAnimation.setCycleCount(Timeline.INDEFINITE);

        this.getChildren().add(pacmanImgView);
    }

    public void playPacmanAnimation(){
        pacmanAnimation.play();
    }

    public void pausePacmanAnimation(){
        pacmanAnimation.pause();
    }

    public void updatePacmanPosition(int row, int column){
        pacmanImgView.setX(column * GameObject.cellSize);
        pacmanImgView.setY(row * GameObject.cellSize);
    }

    public Maze getMaze() {
        return maze;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    public ImageView getPacmanImgView() {
        return pacmanImgView;
    }

    public void setPacmanImgView(ImageView pacmanImgView) {
        this.pacmanImgView = pacmanImgView;
    }

    public Timeline getPacmanAnimation() {
        return pacmanAnimation;
    }

    public void setPacmanAnimation(Timeline pacmanAnimation) {
        this.pacmanAnimation = pacmanAnimation;
    }
}
