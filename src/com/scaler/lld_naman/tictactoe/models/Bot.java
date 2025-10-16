package com.scaler.lld_naman.tictactoe.models;

import com.scaler.lld_naman.tictactoe.strategies.botplayingstrategies.BotPlayingStrategy;
import com.scaler.lld_naman.tictactoe.strategies.botplayingstrategies.BotPlayingStrategyFactory;

public class Bot extends Player{

    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(String name, Symbol symbol, BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyForDifficultyLevel(botDifficultyLevel);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    Cell makeMove(Board board) {

        return botPlayingStrategy.makeMove(board);
    }
}
