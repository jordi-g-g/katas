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

    public void takeField(int x, int y) {
        if (x < 0 || x > board.length || y < 0 || y > board.length) {
            throw new IndexOutOfBoundsException();
        }

        if (fieldCanBeTaken(x, y)) {
            board[x][y] = getCurrentPlayer();
            if (checkIfAllFieldsInAColumnAreTakenBySamePlayer()) {
                gameIsOver = true;
            }
            switchPlayer();
        }
    }

    private boolean fieldCanBeTaken(int x, int y) {
        return board[x][y] == ' ';
    }

    private Boolean checkIfAllFieldsInAColumnAreTakenBySamePlayer() {
        int countFieldsTakenByCurrentPlayer = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == 'X') {
                    countFieldsTakenByCurrentPlayer += 1;
                    if (countFieldsTakenByCurrentPlayer == 3) {
                        return true;
                    }
                }
            }
        }

        return false;
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
        System.out.println("+---+---+---+");
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (col == 0) {
                    System.out.print("|");
                }
                System.out.print(" " + board[row][col] + " |");
            }
            System.out.println();
            System.out.println("+---+---+---+");
        }
    }
}
