package models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int size;
    private Cell[][] grid;
//    private List<List<Cell>> grid;


    public Board(int size) {
        this.size = size;
        // in case of 2D Array
        this.grid = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Cell(i, j);
            }
        }

//        in case of ArrayList
//        for(int i=0; i<size; i++){
//            this.grid = new ArrayList<>();
//            for(int j=0; j<size; j++) {
//                grid.get(i).add(new Cell(i, j));
//            }
//        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void setGrid(Cell[][] grid) {
        this.grid = grid;
    }
}
