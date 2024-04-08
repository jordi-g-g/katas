package com.codurance.kata.tictactoe;

import java.util.List;

public class Game {
    private Board board;
    private final List<Character> players = List.of('X', 'O');
    private int currentPlayerIndex = 0;
    private Boolean gameIsOver = false;

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

    public boolean takeField(int x, int y) {
        if (x < 0 || x > board.getData().length || y < 0 || y > board.getData().length) {
            throw new IndexOutOfBoundsException();
        }

        if (board.getData()[x][y] == ' ') {
            board.setData(x, y, getCurrentPlayer());
            switchPlayer();
            if (checkIfAllFieldsInAColumnAreTakenBySamePlayer()) {
                gameIsOver = true;
            }
            return true;
        }
        return false;
    }

    private Boolean checkIfAllFieldsInAColumnAreTakenBySamePlayer() {
        char[][] data = board.getData();

        for (int col = 0; col < data[0].length; col++) {
            if (data[0][col] != 'X') {
                return false;
            }
        }

        return true;
    }

    public Boolean isGameOver() {
        return gameIsOver;
    }

    private void switchPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public void printBoard() {
        char[][] data = board.getData();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (col == 0) {
                    System.out.print("|");
                }
                System.out.print(data[row][col] + "|");
            }
            System.out.println();
        }
    }
}
