package com.scaler.lld_naman.tictactoe.strategies.botplayingstrategies;

import com.scaler.lld_naman.tictactoe.models.Board;
import com.scaler.lld_naman.tictactoe.models.Cell;
import com.scaler.lld_naman.tictactoe.models.CellState;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {

    @Override
    public Cell makeMove(Board board) {

        for(List<Cell> row : board.getBoard()) {
            for(Cell cell : row){
                if(cell.getCellStatus().equals(CellState.EMPTY)){
                    return cell;
                }
            }
        }
        return null;
    }
}
