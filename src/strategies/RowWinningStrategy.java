package strategies;

import models.Move;
import models.Symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RowWinningStrategy implements WinningStrategy{

    private int size;
    private List<HashMap<Symbol, Integer>> rowMaps;

    public RowWinningStrategy(int size){
        this.size = size;
        rowMaps = new ArrayList<>();
        for(int i=0; i<size; i++){
            rowMaps.add(new HashMap<>());
        }
    }

    @Override
    public boolean checkWinner(Move move) {

        int currRow = move.getCell().getRowVal();
        Symbol currPlayerSymbol = move.getPlayer().getSymbol();

        HashMap<Symbol, Integer> currRowMap = rowMaps.get(currRow);

        if(!currRowMap.containsKey(currPlayerSymbol)){
            currRowMap.put(currPlayerSymbol, 1);
        }
        else currRowMap.put(currPlayerSymbol, currRowMap.get(currPlayerSymbol)+1);

        return currRowMap.get(currPlayerSymbol) == size;
    }
}
