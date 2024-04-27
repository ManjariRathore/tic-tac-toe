package org.example.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class Player {
    private String name;
    private Symbol symbol;
    private EPlayer playerType;
    private static Scanner scanner = new Scanner(System.in);

    public Player(String name, Symbol symbol, EPlayer playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }
    public Move makeMove(Board board){
        System.out.println("It is Player "+this.name+"'s turn to make a move! " );
        // ask user where they would like to place the Symbol
        System.out.println("please enter the row w.r.t the move you would like to make : ");
        int row = scanner.nextInt();
        System.out.println("please enter the col w.r.t the move you would like to make : ");
        int col = scanner.nextInt();
        return new Move(new Cell(row,col) , this );
    }
}
