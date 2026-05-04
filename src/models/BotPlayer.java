package models;

import models.enums.BotDifficulty;
import models.enums.PlayerType;

public class BotPlayer extends Player{

    private BotDifficulty botDifficulty;

    public BotPlayer(int playerId, String name, Symbol symbol, BotDifficulty botDifficulty) {
        super(playerId, name, symbol, PlayerType.BOT);
        this.botDifficulty = botDifficulty;
    }

    public BotDifficulty getBotDifficulty() {
        return botDifficulty;
    }

    public void setBotDifficulty(BotDifficulty botDifficulty) {
        this.botDifficulty = botDifficulty;
    }
}
