package com.codurance.kata.sudoku;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest {
    @Test
    public void givenAnEmptyMatrixShouldReturnInputDoesntComplyWithSudokuRules() {
        Application sut = new Application();

        int[][] input = new int[2][2];

        String actual = sut.execute(input);

        assertEquals("The input doesn't comply with Sudoku's rules.", actual);
    }

    @Test
    public void givenAMatrixWithInvalidValuesShouldReturnInputDoesntComplyWithSudokuRules() {
        Application sut = new Application();

        int[][] input = {
                {1, 2, 2, 3,},
                {2, 1, 4, 3,},
                {3, 4, 1, 2,},
                {4, 3, 2, 1,},
        };
        String actual = sut.execute(input);

        assertEquals("The input doesn't comply with Sudoku's rules.", actual);
    }
}

// TRUE
// result: "The input complies with Sudoku's rules."
