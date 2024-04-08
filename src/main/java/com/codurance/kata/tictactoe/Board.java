package com.codurance.kata.tictactoe;

public class Board {
    private final char[][] data;

    public Board() {
        this.data = new char[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                this.data[row][col] = ' ';
            }
        }
    }

    public char[][] getData() {
        return data;
    }

    public void setData(int x, int y, char value) {
        data[x][y] = value;
    }
}
