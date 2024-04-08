package com.codurance.kata.tictactoe;

import java.util.List;

public class Game {
    private Board board;
    private final List<Character> players = List.of('X', 'O');
    private int currentPlayerIndex = 0;

    public Game() {
        board = new Board();
    }

    public Character getBoardField(int x, int y) {
        return board.getData()[x][y];
    }

    public int numberOfPlayers() {
        return players.size();
    }

    public char getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public void switchPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public boolean takeField(int x, int y) {
        if (x < 0 || x > board.getData().length || y < 0 || y > board.getData().length) {
            throw new IndexOutOfBoundsException();
        }

        if (board.getData()[x][y] == ' ') {
            board.setData(x, y, getCurrentPlayer());
            return true;
        }
        return false;
    }
}
