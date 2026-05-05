package strategies;

import models.Board;
import models.Move;
import models.Player;

public interface BotsPlayingStrategy {

    Move makeMove(Board board, Player player);
}
