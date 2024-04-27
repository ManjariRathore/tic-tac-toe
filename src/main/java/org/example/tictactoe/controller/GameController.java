package org.example.tictactoe.controller;

import org.example.tictactoe.exceptions.InvalidMoveException;
import org.example.tictactoe.models.EGameState;
import org.example.tictactoe.models.Game;
import org.example.tictactoe.models.Player;

import java.util.List;

public class GameController {
    public Game startGame(int dimension , List<Player> players){
        //todo
        //validate the players (check symbols are different)
        //if game not valid return some exception
        return new Game(dimension,players);
    }
     public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove();
    }
    public EGameState checkGameState(Game game){
        return game.getGameState();
    }
    public Player getWinner(Game game){
        return game.getWinner() ;
    }
    public void displayBoard(Game game){
       game.displayBoard();
    }

}
