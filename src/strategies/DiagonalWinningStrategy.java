package strategies;

import models.Move;
import models.Symbol;

import java.util.HashMap;

public class DiagonalWinningStrategy implements WinningStrategy{

    private int size;
    private HashMap<Symbol, Integer> mainDiagMap;
    private HashMap<Symbol, Integer> antiDiagMap;

    public DiagonalWinningStrategy(int size){
        this.size = size;
        mainDiagMap = new HashMap<>();
        antiDiagMap = new HashMap<>();
    }

    @Override
    public boolean checkWinner(Move move) {

        int currentRow = move.getCell().getRowVal();
        int currentCol = move.getCell().getColVal();
        Symbol currPlayerSymbol = move.getPlayer().getSymbol();

        // Player marked on main-diagonal
        if(currentRow == currentCol){
            mainDiagMap.put(currPlayerSymbol,
                    mainDiagMap.getOrDefault(currPlayerSymbol, 0)+1);

            if(mainDiagMap.get(currPlayerSymbol) == size){
                return true;
            }
        }

        // Player marked on anti-diagonal
        if(currentRow + currentCol == size-1){
            antiDiagMap.put(currPlayerSymbol,
                    antiDiagMap.getOrDefault(currPlayerSymbol, 0)+1);

            return antiDiagMap.get(currPlayerSymbol) == size;
        }

        return false;
    }
}
