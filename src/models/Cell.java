package models;

import models.enums.CellState;

public class Cell {

    private int row_no;
    private int col_no;
    private Player player;
    private CellState cellState;

    public Cell(int row_no, int col_no) {
        this.row_no = row_no;
        this.col_no = col_no;
        this.player = null;
        this.cellState = CellState.EMPTY;
    }

    public int getRow_no() {
        return row_no;
    }

    public void setRow_no(int row_no) {
        this.row_no = row_no;
    }

    public int getCol_no() {
        return col_no;
    }

    public void setCol_no(int col_no) {
        this.col_no = col_no;
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
