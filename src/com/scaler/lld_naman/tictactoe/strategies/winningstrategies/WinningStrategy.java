package com.scaler.lld_naman.tictactoe.strategies.winningstrategies;

import com.scaler.lld_naman.tictactoe.models.Board;
import com.scaler.lld_naman.tictactoe.models.Move;

public interface WinningStrategy {

    boolean checkWinner(Board board, Move move);
}
