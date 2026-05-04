package strategies;

import models.Board;
import models.Player;
import models.Symbol;

import java.util.HashMap;

public class DiagonalWinningStrategy implements WinningStrategy{

    private HashMap<Symbol, Integer> diagMap;
    private HashMap<Symbol, Integer> antiDiagMap;

    public DiagonalWinningStrategy(){
        diagMap = new HashMap<>();
        antiDiagMap = new HashMap<>();
    }

    @Override
    public Player checkWinner(Board board) {
        return null;
    }
}
