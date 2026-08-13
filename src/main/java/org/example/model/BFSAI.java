package org.example.model;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFSAI implements GhostAI{

    private static class Node{

        private int row;
        private int column;

        private Node parent;

        public Node(int row, int column, Node parent){
            this.row = row;
            this.column = column;
            this.parent = parent;
        }
    }

    @Override
    public Direction getNextMove(Maze maze, Ghost ghost, Pacman pacman) {

        Queue<Node> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[maze.getRows()][maze.getColumns()];

        Node start = new Node(ghost.getRow(), ghost.getColumn(), null);

        queue.offer(start);
        visited[start.row][start.column] = true;

        while (!queue.isEmpty()){

            Node current = queue.poll();

            if (current.row == pacman.getRow() && current.column == pacman.getColumn()){

                Node temp = current;

                while (temp.parent != start){
                    temp = temp.parent;
                }

                if (start.row - 1 == temp.row){
                    return Direction.UP;
                }
                if (start.row + 1 == temp.row){
                    return Direction.DOWN;
                }
                if (start.column + 1 == temp.column){
                    return Direction.RIGHT;
                }
                if (start.column - 1 == temp.column){
                    return Direction.LEFT;
                }

            }

            for (Direction direction : Direction.values()){

                int nextRow = current.row;
                int nextColumn = current.column;

                switch (direction){
                    case UP -> nextRow--;
                    case DOWN -> nextRow++;
                    case RIGHT -> nextColumn++;
                    case LEFT -> nextColumn--;
                }

                if (!maze.isWall(nextRow, nextColumn) && !visited[nextRow][nextColumn]){
                    visited[nextRow][nextColumn] = true;
                    queue.offer(new Node(nextRow, nextColumn, current));
                }

            }

        }

        return ghost.getDirection();

    }

}
