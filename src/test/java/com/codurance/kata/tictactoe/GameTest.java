package com.codurance.kata.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        game.switchPlayer();
        assertEquals('O', game.getCurrentPlayer());
    }
}
