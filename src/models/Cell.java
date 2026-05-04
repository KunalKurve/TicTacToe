package models;

import models.enums.CellState;

public class Cell {

    private int rowVal;
    private int colVal;
    private Player player;
    private CellState cellState;

    public Cell(int rowVal, int colVal) {
        this.rowVal = rowVal;
        this.colVal = colVal;
        this.player = null;
        this.cellState = CellState.EMPTY;
    }

    public int getRowVal() {
        return rowVal;
    }

    public void setRowVal(int rowVal) {
        this.rowVal = rowVal;
    }

    public int getColVal() {
        return colVal;
    }

    public void setColVal(int colVal) {
        this.colVal = colVal;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }
}
