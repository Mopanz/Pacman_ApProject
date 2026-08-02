package org.example.model;

public abstract class Character extends GameObject{

    private Direction direction;

    public Character(int row, int column, Direction direction){
        super(row, column);
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean canMove(Maze maze, Direction direction){
        int nextRow = getRow();
        int nextColumn = getColumn();

        switch (direction){
            case UP -> nextRow--;
            case DOWN -> nextRow++;
            case RIGHT -> nextColumn++;
            case LEFT -> nextColumn--;
        }

        if (!maze.isWall(nextRow, nextColumn)){
            return true;
        }

        return false;

    }
}
