package com.codurance.kata.tictactoe;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void a_game_has_nine_fields_in_a_3x3_grid() {
        String actual = game.drawBoard();

        String expected = """
                +---+---+---+
                | 1 | 2 | 3 |
                +---+---+---+
                | 4 | 5 | 6 |
                +---+---+---+
                | 7 | 8 | 9 |
                +---+---+---+
                                """;
        assertEquals(expected, actual);
    }

    @Test
    public void there_are_two_players_in_the_game() {
        assertEquals(2, game.numberOfPlayers());
    }

    @Test
    public void player_X_starts_the_game() {
        assertEquals('X', game.getCurrentPlayer());
    }

    @Test
    public void player_O_plays_after_player_X() {
        assertEquals('X', game.getCurrentPlayer());
        game.takeField(1);
        assertEquals('O', game.getCurrentPlayer());
    }

    @Test
    public void a_player_can_take_a_field_if_not_already_taken() {
        int cell = 2;
        char initialPlayer = game.getCurrentPlayer();
        game.takeField(cell);
        assertEquals(initialPlayer, game.getBoardField(cell));
    }

    @Test
    public void a_game_is_not_over_by_default() {
        assertFalse(game.isGameOver());
    }

    @ParameterizedTest
    @CsvSource({
            "1, 5, 3, 9, 2",
            "4, 1, 5, 2, 6",
            "7, 1, 8, 2, 9",
    })
    public void a_game_is_over_when_all_fields_in_a_column_are_taken_by_a_player(
            int take1, int take2, int take3, int take4, int take5
    ) {
        Game game = new Game();
        game.takeField(take1);
        game.takeField(take2);
        game.takeField(take3);
        game.takeField(take4);
        game.takeField(take5);

        System.out.print(game.drawBoard());

        assertTrue(game.isGameOver());
    }

    @ParameterizedTest
    @CsvSource({
            "1, 5, 4, 9, 7",
            "2, 3, 5, 7, 8",
            "3, 4, 6, 7, 9",
    })
    public void a_game_is_over_when_all_fields_in_a_row_are_taken_by_a_player(
            int take1, int take2, int take3, int take4, int take5
    ) {
        Game game = new Game();
        game.takeField(take1);
        game.takeField(take2);
        game.takeField(take3);
        game.takeField(take4);
        game.takeField(take5);

        System.out.print(game.drawBoard());

        assertTrue(game.isGameOver());
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 5, 7, 9",
            "3, 2, 5, 6, 7",
    })
    public void a_game_is_over_when_all_fields_in_a_diagonal_are_taken_by_a_player(
            int take1, int take2, int take3, int take4, int take5
    ) {
        Game game = new Game();
        game.takeField(take1);
        game.takeField(take2);
        game.takeField(take3);
        game.takeField(take4);
        game.takeField(take5);

        System.out.print(game.drawBoard());

        assertTrue(game.isGameOver());
    }

    @Test
    public void a_player_cannot_take_an_already_taken_field() {
        int cell = 2;
        char initialPlayer = game.getCurrentPlayer();
        game.takeField(cell);

        game.takeField(cell);
        assertEquals(initialPlayer, game.getBoardField(cell));
    }

    @ParameterizedTest
    @ValueSource(ints = {-3, 0, 15, Integer.MAX_VALUE})
    public void an_exception_IndexOutOfBoundsException_should_be_thrown_when_out_of_bounds_position_is_intended_to_be_taken(int cell) {
        Game game = new Game();
        assertThrows(IndexOutOfBoundsException.class, () -> game.takeField(cell));
    }

    @Test
    public void a_game_is_over_when_all_fields_are_taken() {
        game.takeField(1);
        game.takeField(5);
        game.takeField(2);
        game.takeField(3);
        game.takeField(7);
        game.takeField(4);
        game.takeField(6);
        game.takeField(9);
        game.takeField(8);

        System.out.print(game.drawBoard());

        assertTrue(game.isGameOver());
    }
}
