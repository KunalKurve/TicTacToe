package strategies;

import models.Move;

public interface WinningStrategy {

   boolean checkWinner(Move move);

    void handleUndo(Move move);
}
