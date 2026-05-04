package strategies;

import models.Board;
import models.Player;
import models.Symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RowWinningStrategy implements WinningStrategy{

    private List<HashMap<Symbol, Integer>> rowMaps;

    public RowWinningStrategy(int size){
         rowMaps = new ArrayList<>();
         for(int i=0; i<size; i++){
            rowMaps.add(new HashMap<>());
         }
    }

    @Override
    public Player checkWinner(Board board) {
        return null;
    }
}
