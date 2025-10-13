package com.scaler.lld_naman.tictactoe.strategies.botplayingstrategies;

import com.scaler.lld_naman.tictactoe.models.Board;
import com.scaler.lld_naman.tictactoe.models.Cell;

public interface BotPlayingStrategy {

    Cell makeMove(Board board);
}
