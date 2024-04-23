package org.example.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Board {

    //size
    private int size;
    private List<List<Cell>> board;
}