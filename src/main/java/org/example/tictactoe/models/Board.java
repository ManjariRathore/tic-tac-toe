package org.example.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Board {

    private int size;
    private List<List<Cell>> board;

    public Board(int size) {
        //create the board
        this.size = size;
        this.board = new ArrayList<>();
        //create empty cells and add them to the board
        for(int i = 0 ; i < size ; i++){
            board.add(new ArrayList<>());
            for(int j = 0 ;  j < size ; j++){
                board.get(i).add(new Cell(i,j));
            }
        }
    }

    public void displayBoard() {
        for (List<Cell> cellRow : board) {
            for (Cell cell : cellRow) {
                if (cell.getCellState().equals(ECellState.EMPTY)) {
                    System.out.print("| - |");
                } else System.out.print("| " + cell.getPlayer().getSymbol().getAChar() + " |");
            }
            System.out.println();

        }
    }
    }