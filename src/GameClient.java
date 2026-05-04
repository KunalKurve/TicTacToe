import controller.GameController;
import models.*;
import models.enums.GameState;
import models.enums.PlayerType;
import strategies.RowWinningStrategy;
import strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

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

        while (game.getGameState().equals(GameState.IN_PROGRESS)){

            //make move
//            Move move = gameController.makeMove(game);
//            //display board
//            gameController.displayGame(game);
//            //check winner
//            if(gameController.checkWinner(move)){
//                game.setGameState(GameState.COMPLETED);
//                game.setWinner(move.getPlayer());
//            }
//            else{
//                game.setGameState(GameState.DRAW);
//            }
        }


    }
}
