package com.codurance.kata.sudoku;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuInputValidatorTest {

    private SudokuInputValidator sudokuInputValidator;

    @BeforeEach
    void setUp() {
        sudokuInputValidator = new SudokuInputValidator();
    }

    // TODO
    @ParameterizedTest
    @CsvSource({"test,TEST", "tEst,TEST", "Java,JAVA"})
    @Test
    public void shouldDetermineWheterAPotencialSolutionIsValid(int[][] input, boolean expected) {
        boolean actual = sudokuInputValidator.isValid(input);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldDetermineAnEmptyMatrixWithEmptyValuesShouldReturnFalse() {
        int[][] input = new int[2][2];

        boolean actual = sudokuInputValidator.isValid(input);

        assertFalse(actual);
    }

    @Test
    public void givenAMatrixWithInvalidValuesShouldReturnFalse() {
        int[][] input = {
                {2, 2, 3, 4,},
                {3, 4, 1, 2,},
                {2, 3, 4, 1,},
                {4, 1, 2, 3,},
        };

        boolean actual = sudokuInputValidator.isValid(input);

        assertFalse(actual);
    }

    @Test
    public void givenAMatrixWithValidValuesShouldReturnTrue() {
        int[][] input = {
                {1, 2, 3, 4,},
                {3, 4, 1, 2,},
                {2, 3, 4, 1,},
                {4, 1, 2, 3,},
        };

        boolean actual = sudokuInputValidator.isValid(input);

        assertTrue(actual);
    }
}
