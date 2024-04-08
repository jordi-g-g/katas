package com.codurance.kata.tictactoe;

import java.util.List;

public class Game {
    private final List<Character> players = List.of('X', 'O');
    private int currentPlayerIndex = 0;

    public int numberOfPlayers() {
        return players.size();
    }

    public char getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public void switchPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }
}
