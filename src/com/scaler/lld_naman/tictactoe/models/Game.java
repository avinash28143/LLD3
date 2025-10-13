package com.scaler.lld_naman.tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Move> moves;
    private Board board;
    private List<Player> players;
    int currentPlayerIndex;
    private List<WinningStrategy> winningStrategies;
    private GameStatus gameStatus;
    private Player winner;


    public Game(int dimensions, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.moves = new ArrayList<>();
        this.board = new Board(3);
        this.players = players;
        currentPlayerIndex = 0;
        this.winningStrategies = winningStrategies;
        this.gameStatus = GameStatus.IN_PROGRESS;

    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<List<Player>> getPlayers() {
        return players;
    }

    public void setPlayers(List<List<Player>> players) {
        this.players = players;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
