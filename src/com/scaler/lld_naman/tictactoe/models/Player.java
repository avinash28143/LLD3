package com.scaler.lld_naman.tictactoe.models;

import java.util.Scanner;

public class Player {
    private String name;
    private Symbol symbol;
   private PlayerType playerType;
   Scanner sc = new Scanner(System.in);

    public Player(String name, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = PlayerType.HUMAN;
        sc = new Scanner(System.in);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    Cell makeMove(Board board) {

        System.out.println("Please tell the row number");
        int row = sc.nextInt();

        System.out.println("Please tell the column number");
        int col = sc.nextInt();


        return new Cell(row, col);
    }
}
