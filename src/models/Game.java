package models;

import models.enums.GameState;
import strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;
    private List<Move> moveHistory;
    private int nextMovePlayer;
    private GameState gameState;
    private Player winner;
    private List<WinningStrategy> winningStrategies;


    public Game(int size, List<Player> players, List<WinningStrategy> winningStrategies) {
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
}
