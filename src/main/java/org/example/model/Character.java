package org.example.model;

public abstract class Character extends GameObject{

    private int previousRow;
    private int previousColumn;

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

    public int getPreviousRow() {
        return previousRow;
    }

    public void setPreviousRow(int previousRow) {
        this.previousRow = previousRow;
    }

    public int getPreviousColumn() {
        return previousColumn;
    }

    public void setPreviousColumn(int previousColumn) {
        this.previousColumn = previousColumn;
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
