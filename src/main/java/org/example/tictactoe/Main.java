package org.example.tictactoe;

import org.example.tictactoe.controller.GameController;
import org.example.tictactoe.models.*;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        List<Player> playerList = List.of(
                new Player("KORO",new Symbol('X'), EPlayer.HUMAN),
                new Player("Lelouch",new Symbol('O'), EPlayer.BOT)
        );
        Game game = gameController.startGame(3,playerList);
        while(gameController.checkGameState(game).equals(EGameState.IN_PROGRESS)){
            //Print the board
            gameController.displayBoard(game);
            //Player makes move
            gameController.makeMove(game);
        }
        if(gameController.checkGameState(game).equals(EGameState.DRAW)){
            System.out.println("Game Draw");
        } else if (gameController.checkGameState(game).equals(EGameState.ENDED)) {
            System.out.println("Player " + gameController.getWinner(game).getName()+" is the winner!!" );
        }
    }
}