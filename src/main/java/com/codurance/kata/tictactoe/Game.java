package com.codurance.kata.tictactoe;

import java.util.List;

public class Game {
    private static int BOARD_SIZE = 9;
    private static int BOARD_MODULE = 3;
    private char[] board;
    private final List<Character> players = List.of('X', 'O');
    private int currentPlayerIndex = 0;
    private Boolean gameIsOver = false;

    public Game() {
        initializeBoard();
    }

    public String drawBoard() {
        StringBuilder output = new StringBuilder("+---+---+---+\n");
        for (int cell = 0; cell < BOARD_SIZE; cell++) {
            if (cell % BOARD_MODULE == 0 && cell < BOARD_SIZE) {
                output.append("|");
            }
            output.append(" ").append(board[cell]).append(" |");
            if (cell % BOARD_MODULE == 2) {
                output.append("\n+---+---+---+\n");
            }
        }

        return output.toString();
    }

    public int numberOfPlayers() {
        return players.size();
    }

    public char getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public void takeField(int cell) {
        validateBoardBounds(cell);

        cell -= 1;
        if (fieldCanBeTaken(cell)) {
            char currentPlayer = getCurrentPlayer();
            board[cell] = currentPlayer;
            gameIsOver = checkGameOver(currentPlayer);
            switchPlayer();
        }
    }

    public Character getBoardField(int cell) {
        validateBoardBounds(cell);

        cell -= 1;
        return board[cell];
    }

    private static void validateBoardBounds(int cell) {
        if (cell <= 0 || cell > BOARD_SIZE) {
            throw new IndexOutOfBoundsException();
        }
    }

    public Boolean isGameOver() {
        return gameIsOver;
    }

    private boolean fieldCanBeTaken(int cell) {
        return board[cell] >= '1' && board[cell] <= '9';
    }

    private boolean checkGameOver(char currentPlayer) {
        return checkIfAllColumnsAreTakenBySamePlayer(currentPlayer) ||
                checkIfAllRowsAreTakenBySamePlayer(currentPlayer) ||
                checkIfAllInDiagonalAreTakenBySamePlayer(currentPlayer);
    }

    private Boolean checkIfAllColumnsAreTakenBySamePlayer(Character player) {
        int countColumnsTakenByPlayer = 0;
        for (int cell = 0; cell < BOARD_SIZE; cell++) {
            if (board[cell] == player) {
                countColumnsTakenByPlayer++;
            }
            if (countColumnsTakenByPlayer == BOARD_MODULE) {
                return true;
            }
            if (cell % BOARD_MODULE == 2) {
                countColumnsTakenByPlayer = 0;
            }
        }

        return false;
    }

    private Boolean checkIfAllRowsAreTakenBySamePlayer(Character player) {
        int countRowsTakenByPlayer = 0;
        for (int start = 0; start < BOARD_MODULE; start++) {
            for (int cellIndex = start; cellIndex < BOARD_SIZE; cellIndex += BOARD_MODULE) {
                if (board[cellIndex] == player) {
                    countRowsTakenByPlayer++;
                }
                if (countRowsTakenByPlayer == BOARD_MODULE) {
                    return true;
                }
            }
            countRowsTakenByPlayer = 0;
        }

        return false;
    }

    private boolean checkIfAllInDiagonalAreTakenBySamePlayer(char currentPlayer) {
        if (board[0] == currentPlayer && board[4] == currentPlayer && board[8] == currentPlayer) {
            return true;
        }
        return board[2] == currentPlayer && board[4] == currentPlayer && board[6] == currentPlayer;
    }

    private void initializeBoard() {
        board = new char[BOARD_SIZE];
        for (int cell = 0; cell < BOARD_SIZE; cell++) {
            board[cell] = (char) ('1' + cell);
        }
    }

    private void switchPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }
}
