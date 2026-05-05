package models;

import exceptions.InvalidBotCountException;
import exceptions.InvalidPlayerCountException;
import exceptions.RepeatedSymbolException;
import models.enums.CellState;
import models.enums.GameState;
import models.enums.PlayerType;
import strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;
    private List<Move> moveHistory; // undo feature
    private int nextMovePlayer; // player rotation
    private GameState gameState;
    private Player winner;
    private List<WinningStrategy> winningStrategies;

    // for implementing Builder Design Pattern - creating Game only when Validations are passed
    private Game(int size, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.board = new Board(size);
        this.players = players;
        this.moveHistory = new ArrayList<>();
        this.nextMovePlayer = 0;
        this.gameState = GameState.IN_PROGRESS;
        this.winner = null;
        this.winningStrategies = winningStrategies;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoveHistory() {
        return moveHistory;
    }

    public void setMoveHistory(List<Move> moveHistory) {
        this.moveHistory = moveHistory;
    }

    public int getNextMovePlayer() {
        return nextMovePlayer;
    }

    public void setNextMovePlayer(int nextMovePlayer) {
        this.nextMovePlayer = nextMovePlayer;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void makeMove(Board board) {
        Player currentPlayer = players.get(nextMovePlayer);
        System.out.println("It's " + currentPlayer.getName() + "'s turn to make move");

        Move move = currentPlayer.makeMove(board);
        moveHistory.add(move);

        nextMovePlayer = (nextMovePlayer + 1) % players.size();

        if(checkWinner(move)){
            this.winner = currentPlayer;
            this.setGameState(GameState.COMPLETED);
        }
        else if(moveHistory.size() == board.getSize() * board.getSize()){
            this.winner = null;
            this.setGameState(GameState.DRAW);
        }
    }

    public boolean checkWinner(Move move) {
        for(WinningStrategy strategy : winningStrategies){
            if(strategy.checkWinner(move)){
                return true;
            }
        }
        return false;
    }

    public void undoMove(){
        if(this.moveHistory.isEmpty()){
            System.out.println("No moves to undo");
        }

        Move move = moveHistory.removeLast();
        Cell cell = move.getCell();
        cell.setCellState(CellState.EMPTY);
        cell.setPlayer(null);

        nextMovePlayer = (nextMovePlayer-1)%players.size();

        for (WinningStrategy strategy : winningStrategies){
            strategy.handleUndo(move);
        }

        this.winner = null;
        this.setGameState(GameState.IN_PROGRESS);

    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder {

        private int size;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        private void validate(){
            validateNumberOfPlayers();
            validateBotCount();
            validateUniquePlayerSymbols();
        }

        private void validateNumberOfPlayers(){
            if(players.size() != size-1){
                throw new InvalidPlayerCountException("Invalid Player Count");
            }
        }

        private void validateUniquePlayerSymbols(){
            HashSet<Symbol> uniqueSymbols = new HashSet<>();
            for (Player player : players){
                if (uniqueSymbols.contains(player.getSymbol())){
                    throw new RepeatedSymbolException("Each Player must have Unique Symbol");
                }
                uniqueSymbols.add(player.getSymbol());
            }
        }

        private void validateBotCount(){
            int botCount = 0;
            for (Player player : players){
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    botCount++;
                }
                if(botCount > 1){
                    throw new InvalidBotCountException("Bot Count cannot be more than 1");
                }
            }
        }

        public Game build(){
            validate();
            return new Game(size, players, winningStrategies);
        }
    }
}
