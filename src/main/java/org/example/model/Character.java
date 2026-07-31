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

    public abstract boolean canMove(Maze maze, Direction direction);
}
