package com.scaler.lld_naman.tictactoe;

import com.scaler.lld_naman.tictactoe.controllers.GameController;
import com.scaler.lld_naman.tictactoe.models.*;
import com.scaler.lld_naman.tictactoe.strategies.winningstrategies.OrderOneColumnWinningStrategy;
import com.scaler.lld_naman.tictactoe.strategies.winningstrategies.OrderOneDiagonalWinningStrategy;
import com.scaler.lld_naman.tictactoe.strategies.winningstrategies.OrderOneRowWinningStrategy;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create game
        GameController gameController = new GameController();

        //Game game = gameController.createGame();
        Game game;
        List<Player> players = List.of(
                new Player("Avinash", new Symbol('X'), PlayerType.HUMAN),
                new Bot("Robo", new Symbol('o'), BotDifficultyLevel.EASY)
        );
        int dimensions = 3;

        try{
            game = gameController.createGame(
                    dimensions,
                    players,
                    List.of(
                            new OrderOneRowWinningStrategy(dimensions, players),
                            new OrderOneColumnWinningStrategy(dimensions, players),
                            new OrderOneDiagonalWinningStrategy(dimensions, players)
                    )
            );
        }catch (Exception e){
            System.out.println("Something went wrong!");
            return;
        }


        System.out.println("-------------Game Starting-------------");
        // While Game status is in Progress
        while(gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)){
            //Print board
            gameController.diplayBoard(game);

            //print if undo
            System.out.println("Does anyone want to undo the recent move? (y/n)");
            Scanner sc = new Scanner(System.in);
            String input = sc.next();
            //print yes -> call undo
            if(input.equalsIgnoreCase("y")){
                gameController.undo(game);
            }else{
                // Move next player
                gameController.makeMove(game);
            }
        }
        // Moving the code to GameController's printResult method
//        // check status of game
//        if(gameController.getGameStatus().equals(GameStatus.ENDED)){
//            // if winner -> print winner
//            gameController.printWinner();
//        }else {
//            // else-> print draw
//            System.out.println("Game is a draw");
//        }

        gameController.printResult(game);
    }
}
