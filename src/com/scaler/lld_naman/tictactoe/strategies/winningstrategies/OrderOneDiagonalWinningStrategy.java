package com.scaler.lld_naman.tictactoe.strategies.winningstrategies;

import com.scaler.lld_naman.tictactoe.models.Board;
import com.scaler.lld_naman.tictactoe.models.Move;
import com.scaler.lld_naman.tictactoe.models.Player;
import com.scaler.lld_naman.tictactoe.models.Symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneDiagonalWinningStrategy implements WinningStrategy {

    private HashMap<Symbol, Integer> leftDiagonalMap;
    private HashMap<Symbol, Integer> rightDiagonalMap;

    public OrderOneDiagonalWinningStrategy(int size, List<Player> players){

        leftDiagonalMap = new HashMap<>();
        rightDiagonalMap = new HashMap<>();

        for(Player player : players){
            leftDiagonalMap.put(player.getSymbol(), 0);
            rightDiagonalMap.put(player.getSymbol(), 0);
        }
    }

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if(row == col){
            leftDiagonalMap.put(symbol, 1 + leftDiagonalMap.get(symbol));
        }

        if(row + col == board.getSize() - 1){
            rightDiagonalMap.put(symbol, 1 + rightDiagonalMap.get(symbol));
        }

        if(row == col){
            if(leftDiagonalMap.get(symbol) == board.getSize()){
                return true;
            }
        }

        if(row+col == board.getSize()-1){
            if(rightDiagonalMap.get(symbol) == board.getSize()){
                return true;
            }
        }


        return false;
    }

    public void handleUndo(Board board, Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Symbol symbol = move.getPlayer().getSymbol();

        if(row == col){
            leftDiagonalMap.put(symbol, leftDiagonalMap.get(symbol)-1);
        }

        if(row+col == board.getSize()-1){
            rightDiagonalMap.put(symbol, rightDiagonalMap.get(symbol)-1);
        }

    }

}
