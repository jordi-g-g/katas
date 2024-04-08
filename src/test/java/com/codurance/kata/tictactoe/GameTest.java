package com.codurance.kata.tictactoe;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void there_are_two_player_in_the_game() {
        assertEquals(2, game.numberOfPlayers());
    }

    @Test
    public void player_X_starts_the_game() {
        assertEquals('X', game.getCurrentPlayer());
    }

    @Test
    public void player_O_plays_after_player_X() {
        assertEquals('X', game.getCurrentPlayer());
        game.takeField(0, 0);
        assertEquals('O', game.getCurrentPlayer());
    }

    @Test
    public void a_player_can_take_a_field_if_not_already_taken() {
        int x = 0;
        int y = 0;
        char initialPlayer = game.getCurrentPlayer();
        boolean firstAttempt = game.takeField(x, y);
        assertTrue(firstAttempt);
        assertEquals(initialPlayer, game.getBoardField(x, y));
    }

    @Test
    public void a_game_is_over_when_all_fields_in_a_column_are_taken_by_a_player() {
        game.takeField(0, 0);
        game.takeField(1, 1);
        game.takeField(0, 1);
        game.takeField(2, 0);
        game.takeField(0, 2);

        game.printBoard();

        assertEquals(true, game.isGameOver());
    }

    @Test
    public void a_player_cannot_take_an_already_taken_field() {
        int x = 0;
        int y = 0;
        boolean firstAttempt = game.takeField(x, y);
        assertTrue(firstAttempt);

        boolean secondAttempt = game.takeField(x, y);
        assertFalse(secondAttempt);
    }

    @ParameterizedTest
    @CsvSource({
            "9,  0",
            "0,  9",
            "9,  9",
    })
    public void an_exception_IndexOutOfBoundsException_should_be_thrown_when_out_of_bounds_position_is_intended_to_be_taken(int x, int y) {
        Game game = new Game();
        assertThrows(IndexOutOfBoundsException.class, () -> game.takeField(x, y));
    }
}
