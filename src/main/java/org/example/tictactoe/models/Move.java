package org.example.tictactoe.models;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Move {
    private Cell cell;
    private Player player;
}
