package strategies;


import models.Move;
import models.Symbol;

import java.util.HashMap;

public class ColumnWinningStrategy implements WinningStrategy{

    private int size;
    private HashMap<Symbol, Integer> colMaps[];

    public ColumnWinningStrategy(int size){
        this.size = size;
        colMaps = new HashMap[size];

        for(int i=0; i<size; i++){
             colMaps[i] = new HashMap<>();
        }
    }

    @Override
    public boolean checkWinner(Move move) {

        int currCol = move.getCell().getColVal();
        Symbol currPlayerSymbol = move.getPlayer().getSymbol();

        HashMap currColMap = colMaps[currCol];

        currColMap.put(
                currPlayerSymbol,
                (int) currColMap.getOrDefault(currPlayerSymbol, 0) + 1
        );

        return currColMap.get(currPlayerSymbol).equals(size);
    }

    @Override
    public void handleUndo(Move move) {

        int currCol = move.getCell().getColVal();
        Symbol currPlayerSymbol = move.getPlayer().getSymbol();

        HashMap currColMap = colMaps[currCol];

        currColMap.put(currPlayerSymbol, (int) currColMap.get(currPlayerSymbol)-1);
    }
}
