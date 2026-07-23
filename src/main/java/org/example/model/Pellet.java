package org.example.model;

public class Pellet extends GameObject{

    private boolean eaten;

    public Pellet(int row, int column){
        super(row, column);
        eaten = false;
    }

     public boolean isEaten(){
        return eaten;
     }

     public void eat(){
        eaten = true;
     }
}
