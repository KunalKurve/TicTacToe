package strategies;

import models.Board;
import models.Player;
import models.Symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ColumnWinningStrategy implements WinningStrategy{

    private HashMap[] colMaps;

    public ColumnWinningStrategy(int size){

        colMaps = new HashMap[size];

        for(int i=0; i<size; i++){
             colMaps[i] = new HashMap<Symbol, Integer>();

        }
    }

    @Override
    public Player checkWinner(Board board) {
        return null;
    }
}
