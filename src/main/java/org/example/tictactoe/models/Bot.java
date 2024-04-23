package org.example.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bot extends Player {
    private EDifficultyLevel botDifficulty;
}
