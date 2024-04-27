package org.example.tictactoe.models;

import lombok.Getter;
import lombok.Setter;
import org.example.tictactoe.exceptions.InvalidMoveException;
import org.example.tictactoe.strategy.WinningAlgorithm;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Game {
    private Board board;
    private Player winner;
    private List<Move> moves;
    private EGameState gameState;
    private List<Player> players;
    private int nextPlayerMoveIndex;
    private WinningAlgorithm winningAlgorithm;

    public Game(int dimensions, List<Player> players) {
        this.winningAlgorithm = new WinningAlgorithm();
        this.gameState = EGameState.IN_PROGRESS;
        this.board = new Board(dimensions);
        this.moves = new ArrayList<>();
        this.nextPlayerMoveIndex = 0;
        this.players = players;
        this.winner = null;
    }

    public void displayBoard() {
        this.board.displayBoard();
    }

    public void makeMove() throws InvalidMoveException {

        Player currentPlayer = players.get(nextPlayerMoveIndex);
        //move that the player wants
        Move move = currentPlayer.makeMove(board);

        if(!validMove(move)){
            throw new InvalidMoveException("Invalid move made by "+currentPlayer.getName());
        }
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cellToChange = board.getBoard().get(row).get(col);
        cellToChange.setPlayer(currentPlayer);
        cellToChange.setCellState(ECellState.FILLED);
        //add the move to the list of moves
        Move finalMove = new Move(cellToChange,currentPlayer);
        moves.add(finalMove);

        //increment the current player pointer
        nextPlayerMoveIndex++;
        nextPlayerMoveIndex%=players.size();

        //check for a winner
        if (winningAlgorithm.checkWinner(board, finalMove)) {
            gameState = EGameState.ENDED;
            winner = currentPlayer;
        }
        if ( moves.size() == board.getSize() * board.getSize())gameState = EGameState.DRAW;
    }

    private boolean validMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(row<0 || row>=board.getSize() || col<0 || col>= board.getSize())return false;

        return board.getBoard().get(row).get(col).getCellState().equals( ECellState.EMPTY);
    }
}
