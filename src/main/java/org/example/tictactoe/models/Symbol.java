package org.example.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class  Symbol {
    private char aChar;

    public Symbol(char aChar) {
        this.aChar = aChar;
    }
}
