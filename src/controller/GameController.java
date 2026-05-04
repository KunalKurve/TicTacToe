package controller;

import models.Game;
import models.Move;
import models.Player;
import strategies.WinningStrategy;

import java.util.List;

public class GameController {

    public Game playNewGame(int size,
                            List<Player> players,
                            List<WinningStrategy> winStrategies){
        return new Game(size, players, winStrategies);
    }


    public void displayGame(Game game) {
        game.getBoard().displayBoard();
    }

//    public Move makeMove(Game game) {
//        game.makeMove();
//    }
}
