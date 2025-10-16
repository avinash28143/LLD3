package com.scaler.lld_naman.tictactoe.models;

import com.scaler.lld_naman.tictactoe.strategies.winningstrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private List<Move> moves;
    private Board board;
    private List<Player> players;
    int currentPlayerIndex;
    private List<WinningStrategy> winningStrategies;
    private GameStatus gameStatus;
    private Player winner;

    public static Builder getBuilder(){
        return new Builder();
    }


    private Game(int dimensions, List<Player> players, List<WinningStrategy> winningStrategies) {
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

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
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

    public void printBoard(){
        this.board.print();
    }

    public void printResult(){
        if(gameStatus == GameStatus.ENDED){

            System.out.println("Game has ended");
            System.out.println("Winner is " + winner.getName());
        }else {
            System.out.println("Game is a draw");
        }
    }

    private boolean validateMove(Cell cell) {
        int row = cell.getRow();
        int col = cell.getCol();

        if(row<0 || col<0 || row>= board.getSize() || col>= board.getSize()){
            return false;
        }

        if(board.getBoard().get(row).get(col).getCellStatus() == CellState.EMPTY){
            return true;
        }
        return false;
    }

    public void makeMove() {
        Player currentPlayer = players.get(currentPlayerIndex);
        System.out.println("This is "+ currentPlayer.getName() + "'s turn.");
        Cell proposedCell = currentPlayer.makeMove(board);

        System.out.println("Move made at row: " + proposedCell.getRow() + " col: " + proposedCell.getCol());
        if( !validateMove(proposedCell)){
            System.out.println("Invalid move. Please try again.");
            return;
        }

        Cell cellInboard = board.getBoard().get(proposedCell.getRow()).get(proposedCell.getCol());
        cellInboard.setStatus(CellState.FILLED);
        cellInboard.setPlayer(currentPlayer);


        Move move = new Move(currentPlayer, cellInboard);
        moves.add(move);

        if (checkGameWon(move, currentPlayer)) return;

        if (checkDraw()) return;

        currentPlayerIndex = currentPlayerIndex + 1;
        currentPlayerIndex = currentPlayerIndex % players.size();
    }

    private boolean checkDraw() {
        if(moves.size() == board.getSize() * board.getSize()){
            gameStatus = GameStatus.DRAW;
            return true;
        }
        return false;
    }

    private boolean checkGameWon(Move move, Player currentPlayer) {
        for(WinningStrategy winningStrategy : winningStrategies){
            if(winningStrategy.checkWinner(board, move)){
                winner = currentPlayer;
                gameStatus = GameStatus.ENDED;
                return true;
            }
        }
        return false;
    }

    public void undo(){

        if(moves.size() == 0){
            System.out.println("No moves present to undo");
            return;
        }

        Move lastMove = moves.get(moves.size()-1);

        for(WinningStrategy winningStrategy : winningStrategies){
            winningStrategy.handleUndo(board, lastMove);
        }

        Cell lastMoveCell = lastMove.getCell();
        lastMoveCell.setStatus(CellState.EMPTY);
        lastMoveCell.setPlayer(null);

        moves.remove(lastMove);


        currentPlayerIndex -= currentPlayerIndex;
        currentPlayerIndex = currentPlayerIndex + players.size();
        currentPlayerIndex = currentPlayerIndex % players.size();
    }

//    public void printWinner() {
//        System.out.println("Winner is:" + winner);
//    }








    public static class Builder{

        private int dimensions;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        private Builder(){
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
            this.dimensions = 0;
        };


        public Builder setDimension(int dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }


        private boolean valid() {

            if(this.players.size() <2){
                return false;
            }

            if(this.players.size() != this.dimensions-1 ){
                return false;
            }

            int botCount = 0;

            for(Player player : this.players){
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    botCount++;
                }
            }

            if(botCount > 1){
                return false;
            }

            Set<Character> existingSymbols = new HashSet<>();
            for(Player player : this.players){
                if(!existingSymbols.contains(player.getSymbol().getChar())){
                    existingSymbols.add(player.getSymbol().getChar());
                }else{
                    return false;
                }
            }

           return true;
        }

        public Game build(){

            if(!valid()){
                throw new RuntimeException("Please enter valid data to create game");
            }
            Game game = new Game(dimensions, players, winningStrategies);
            return game;
        }


    }
}
