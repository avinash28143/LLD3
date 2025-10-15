package com.scaler.lld_naman.tictactoe.controllers;

import com.scaler.lld_naman.tictactoe.models.Game;
import com.scaler.lld_naman.tictactoe.models.GameStatus;
import com.scaler.lld_naman.tictactoe.models.Player;
import com.scaler.lld_naman.tictactoe.strategies.winningstrategies.WinningStrategy;

import java.util.List;

public class GameController {

    public Game createGame(int dimensions,
                           List<Player> players,
                           List<WinningStrategy> winningStrategies){

        return Game.getBuilder()
                .setDimension(dimensions)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();

    }

    public void diplayBoard(Game game){
        game.printBoard();
    }

    public void undo(Game game){

    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }

//    public void printWinner(Game game){
//        game.printWinner();
//    }

    public void printResult(Game game){
        game.printResult();
        // check status of game
//        if(getGameStatus().equals(GameStatus.ENDED)){
//            // if winner -> print winner
//            printWinner();
//        }else {
//            // else-> print draw
//            System.out.println("Game is a draw");
//        }
    }
}
