package controller;

import models.Game;
import models.Move;
import models.Player;
import models.enums.GameState;
import strategies.WinningStrategy;

import java.util.List;
import java.util.Scanner;

public class GameController {

    // startGame method
    public Game playNewGame(int size,
                            List<Player> players,
                            List<WinningStrategy> winStrategies){

        return Game.getBuilder()
                .setSize(size)
                .setPlayers(players)
                .setWinningStrategies(winStrategies)
                .build();
    }

    // display method
    public void displayGame(Game game) {
        game.getBoard().displayBoard();
    }

    // make moves method
    public void makeMove(Game game) {
        game.makeMove(game.getBoard());
    }

    // Fetching Winner
    public Player getWinner(Game game){
        return game.getWinner();
    }

    // undo moves method
    public void undoMove(Game game){
        game.undoMove();
    }

    // get game state method
    public GameState getGameState(Game game){
        return game.getGameState();
    }

    // get next player method
    public Player getNextPlayer(Game game){
        // to use for passing row and col values from Client
        // if player is Human
        return game.getPlayers().get(game.getNextMovePlayer());
    }
}
