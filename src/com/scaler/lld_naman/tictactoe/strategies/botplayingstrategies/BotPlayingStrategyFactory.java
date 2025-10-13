package com.scaler.lld_naman.tictactoe.strategies.botplayingstrategies;

import com.scaler.lld_naman.tictactoe.models.Board;
import com.scaler.lld_naman.tictactoe.models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategyForDifficultyLevel(BotDifficultyLevel difficultyLevel) {

       return switch (difficultyLevel) {
            case EASY ->  new EasyBotPlayingStrategy();
            case MEDIUM ->  new MediumBotPlayingStrategy();
            case HARD ->  new HardBotPlayingStrategy();
   //         default: return new EasyBotPlayingStrategy();
        };
    }
}