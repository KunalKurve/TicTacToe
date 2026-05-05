package models;

import factory.BotsPlayingStrategyFactory;
import models.enums.BotDifficulty;
import models.enums.PlayerType;
import strategies.BotsPlayingStrategy;

public class BotPlayer extends Player{

    private BotDifficulty botDifficulty;
    private BotsPlayingStrategy botsPlayingStrategy;

    public BotPlayer(int playerId, String name, Symbol symbol, BotDifficulty botDifficulty) {
        super(playerId, name, symbol, PlayerType.BOT);
        this.botDifficulty = botDifficulty;
        this.botsPlayingStrategy = BotsPlayingStrategyFactory.getBotsPlayingStrategy(botDifficulty);
    }

    public BotDifficulty getBotDifficulty() {
        return botDifficulty;
    }

    public void setBotDifficulty(BotDifficulty botDifficulty) {
        this.botDifficulty = botDifficulty;
    }

    @Override
    public Move makeMove(Board board) {
        return botsPlayingStrategy.makeMove(board, this);
    }
}
