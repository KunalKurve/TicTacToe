package factory;

import models.enums.BotDifficulty;
import strategies.BotsPlayingStrategy;
import strategies.EasyPlayingStrategy;
import strategies.HardPlayingStrategy;
import strategies.MediumPlayingStrategy;

public class BotsPlayingStrategyFactory {

    public static BotsPlayingStrategy getBotsPlayingStrategy(BotDifficulty botDifficulty){

        // Implemented the Factory Design Pattern
        if(botDifficulty.equals(BotDifficulty.EASY)){
            return new EasyPlayingStrategy();
        }
        else if(botDifficulty.equals(BotDifficulty.MEDIUM)){
            return new MediumPlayingStrategy();
        }
        else if(botDifficulty.equals(BotDifficulty.HARD)) {
            return new HardPlayingStrategy();
        }
        return null;
    }
}
