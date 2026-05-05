package strategies;

import models.Board;
import models.Cell;
import models.Move;
import models.Player;
import models.enums.CellState;

public class EasyPlayingStrategy implements BotsPlayingStrategy{
    @Override
    public Move makeMove(Board board, Player player) {
        for(Cell[] cellList : board.getGrid()){
            for(Cell cell : cellList){
                if(cell.getCellState().equals(CellState.EMPTY)){
                    cell.setCellState(CellState.FILLED);
                    cell.setPlayer(player);
                    return new Move(player, cell);
                }
            }
        }
        return null;
    }
}
