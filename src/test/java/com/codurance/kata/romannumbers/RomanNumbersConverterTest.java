package com.codurance.kata.romannumbers;

import org.junit.Test;

import static com.codurance.kata.romannumbers.RomanNumbersConverter.convert;
import static org.junit.jupiter.api.Assertions.*;

public class RomanNumbersConverterTest {
    @Test
    public void convert_Arabic_numbers_into_their_Roman_numeral_equivalents() {
        assertEquals("I", convert(1));
        assertEquals("II", convert(2));
        assertEquals("III", convert(3));
        assertEquals("IV", convert(4));
    }
}
