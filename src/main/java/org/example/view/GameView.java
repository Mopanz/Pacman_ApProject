package org.example.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import org.example.model.GameObject;
import org.example.model.LevelsGrid;
import org.example.model.Maze;

public class GameView extends Pane {

    private Maze maze;

    public GameView(){

        maze = new Maze(LevelsGrid.getLevel1());

        this.setStyle("-fx-background-color: black;");
        this.setPrefSize(maze.getColumns() * GameObject.cellSize, maze.getRows() * GameObject.cellSize);

        drawMaze();
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

    public Maze getMaze() {
        return maze;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }
}
