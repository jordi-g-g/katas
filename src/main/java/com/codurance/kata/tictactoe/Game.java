package com.codurance.kata.tictactoe;

import java.util.List;

public class Game {
    private char[][] board;
    private final List<Character> players = List.of('X', 'O');
    private int currentPlayerIndex = 0;
    private Boolean gameIsOver = false;

    public Game() {
        initializeBoard();
    }

    public char[][] getBoard() {
        return board;
    }

    public Character getBoardField(int x, int y) {
        return board[x][y];
    }

    public int numberOfPlayers() {
        return players.size();
    }

    public char getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public boolean takeField(int x, int y) {
        if (x < 0 || x > board.length || y < 0 || y > board.length) {
            throw new IndexOutOfBoundsException();
        }

        if (board[x][y] == ' ') {
            board[x][y] = getCurrentPlayer();
            switchPlayer();
            if (checkIfAllFieldsInAColumnAreTakenBySamePlayer()) {
                gameIsOver = true;
            }
            return true;
        }
        return false;
    }

    private Boolean checkIfAllFieldsInAColumnAreTakenBySamePlayer() {
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] != 'X') {
                return false;
            }
        }

        return true;
    }

    public Boolean isGameOver() {
        return gameIsOver;
    }

    private void initializeBoard() {
        board = new char[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
    }

    private void switchPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public void printBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (col == 0) {
                    System.out.print("|");
                }
                System.out.print(board[row][col] + "|");
            }
            System.out.println();
        }
    }
}
