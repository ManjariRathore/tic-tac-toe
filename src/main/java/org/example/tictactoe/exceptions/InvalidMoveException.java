package org.example.tictactoe.exceptions;

public class InvalidMoveException extends RuntimeException{
    public InvalidMoveException(String message){
        super(message);
    }
}
