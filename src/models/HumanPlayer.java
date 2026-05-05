package models;

import models.enums.CellState;
import models.enums.PlayerType;

import java.util.Scanner;

public class HumanPlayer extends Player{

    private int age;

    public HumanPlayer(int playerId, String name, Symbol symbol, int age) {
        super(playerId, name, symbol, PlayerType.HUMAN);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void validateMove(int row, int col, Board board) {
        if (row < 0 || row >= board.getSize()){
            throw new RuntimeException("Invalid Row");
        }
        if (col < 0 || col >= board.getSize()){
            throw new RuntimeException("Invalid Col");
        }

        if(board.getGrid()[row][col].getCellState().equals(CellState.FILLED)){
            throw new RuntimeException("Already Filled");
        }
    }

    @Override
    public Move makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give row and col of the cell");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        // validate
        validateMove(row, col, board);

        Cell cell = board.getGrid()[row][col];
        cell.setPlayer(this);
        cell.setCellState(CellState.FILLED);
        return new Move(this, cell);

    }
}
