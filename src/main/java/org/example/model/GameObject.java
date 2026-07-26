package org.example.model;

public abstract class GameObject {

    public static final int cellSize = 20;

    private int row;
    private int column;

    public GameObject(int row, int column){
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPixelX(){
        return row * cellSize;
    }

    public int getPixelY(){
        return column * cellSize;
    }

}
