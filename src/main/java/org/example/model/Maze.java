package org.example.model;

import java.util.ArrayList;

public class Maze {

    private int[][] grid;
    private int rows;
    private int columns;

    private ArrayList<Pellet> pellets;

    public Maze(int[][] grid){

        pellets = new ArrayList<>();
        this.grid = grid;
        this.rows = grid.length;
        this.columns = grid[0].length;

        intializePellets();
    }

    private void intializePellets(){
        for (int i=0; i<rows; i++){
            for (int j=0; j<columns; j++){
                if (grid[i][j] == 0){
                    pellets.add(new Pellet(i, j));
                }
            }
        }
    }

    public boolean isWall(int row, int column){
        if (row<0 || row>=rows || column<0 || column>=columns){
            return true;
        }
        return grid[row][column] == 1;
    }

    public Pellet getPelletAt(int row, int column){
        for (Pellet p : pellets){
            if (p.getRow()==row && p.getColumn()==column){
                return p;
            }
        }
        return null;
    }

    public boolean areAllPelletsEaten(){
        for (Pellet p : pellets){
            if (!p.isEaten()){
                return false;
            }
        }
        return true;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public ArrayList<Pellet> getPellets() {
        return pellets;
    }

    public void setPellets(ArrayList<Pellet> pellets) {
        this.pellets = pellets;
    }

}
