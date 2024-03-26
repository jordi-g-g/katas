package com.codurance.kata.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    public void a_game_has_nine_fields_in_a_3x3_grid() {
        Board board = new Board();

        assertEquals(3, board.getData().length);
        for (int row = 0; row < 3; row++) {
            assertEquals(3, board.getData()[row].length);
        }
    }
}
