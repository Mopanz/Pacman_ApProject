package org.example.model;

public class Pacman extends Character{

    private boolean alive;
    private boolean moving;

    public Pacman(int row, int column){
        super(row, column, Direction.RIGHT);
        alive = true;
        moving = false;
    }

    public boolean isAlive(){
        return alive;
    }

    public void die(){
        alive = false;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving){
        this.moving = moving;
    }
}
