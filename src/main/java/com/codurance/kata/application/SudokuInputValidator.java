package com.codurance.kata.application;

import java.util.ArrayList;
import java.util.List;

public class SudokuInputValidator {
    public boolean isValid(int[][] input) {
        List<Integer> state = new ArrayList<>();
        for (int col = 0; col < input[0].length; col++) {
            state.add(input[0][col]);
        }

        if (state.stream().distinct().count() != input[0].length) {
            return false;
        }

        return true;
    }

    private boolean isValidColumn() {
        return true;
    }

    private boolean isValidRow() {
        return true;
    }

    private boolean isValidQuadrant() {
        return true;
    }
}
