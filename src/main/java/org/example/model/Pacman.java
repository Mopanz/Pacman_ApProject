package org.example.model;

public class Pacman extends Character{

    private boolean alive;

    public Pacman(int row, int column){
        super(row, column, Direction.RIGHT);
        alive = true;
    }


    @Override
    public void move(Maze maze) {

        int nextRow = getRow();
        int nextColumn = getColumn();

        switch (getDirection()){
            case UP -> nextRow--;
            case DOWN -> nextRow++;
            case RIGHT -> nextColumn++;
            case LEFT -> nextColumn--;
        }

        if (!maze.isWall(nextRow, nextColumn)){
            setRow(nextRow);
            setColumn(nextColumn);
        }

    }

    public boolean isAlive(){
        return alive;
    }

    public void die(){
        alive = false;
    }
}
