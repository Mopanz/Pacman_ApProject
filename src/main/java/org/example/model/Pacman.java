package org.example.model;

public class Pacman extends Character{

    private boolean moving;

    public Pacman(int row, int column){
        super(row, column, Direction.RIGHT);
        moving = false;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving){
        this.moving = moving;
    }
}
