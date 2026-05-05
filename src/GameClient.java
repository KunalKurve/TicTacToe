import controller.GameController;
import models.*;
import models.enums.GameState;
import strategies.RowWinningStrategy;
import strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameClient {
    public static void main(String[] args) {

        GameController gameController = new GameController();

        int size = 3;
        List<Player> players = new ArrayList<>();
        Symbol s1 = new Symbol("X");
        Player p1 = new HumanPlayer(1, "Kunal", s1, 26);

        Symbol s2 = new Symbol("0");
        Player p2 = new HumanPlayer(2, "Prixie", s2, 35);

        players.add(p1);
        players.add(p2);

        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy(size));

        Game game = gameController.playNewGame(size, players, winningStrategies);

        //display board
        gameController.displayGame(game);

        Scanner scanner = new Scanner(System.in);

        while (game.getGameState().equals(GameState.IN_PROGRESS)){
            // Flow
            // 1. display board
            gameController.displayGame(game);

            // 2. Ask Player if it wants to make move or undo move
            System.out.println("Type M to make move");
            System.out.println("Type U to undo move");
            String input = scanner.next();
            if(input.equalsIgnoreCase("m")){
                gameController.makeMove(game);
            }
            else gameController.undoMove(game);

        }

        if(gameController.getGameState(game).equals(GameState.COMPLETED)){
            Player winner = gameController.getWinner(game);
            System.out.println("Congratulations " + winner.getName() + " has Won!");
        }
        else{
            gameController.displayGame(game);
            System.out.println("Game is Drawn!");
        }
    }
}
