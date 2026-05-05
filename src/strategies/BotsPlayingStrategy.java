package strategies;

import models.Board;
import models.Move;
import models.Player;

public interface BotsPlayingStrategy {
    // Implemented the Strategy Design Pattern
    Move makeMove(Board board, Player player);
}
