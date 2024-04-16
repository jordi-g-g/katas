package com.codurance.kata.romannumbers;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RomanNumbersConverterTest {
    @Test
    public void convert_Arabic_numbers_into_their_Roman_numeral_equivalents() {
        RomanNumbersConverter romanNumbersConverter = new RomanNumbersConverter();

        assertEquals("I", romanNumbersConverter.convert(1));
        assertEquals("II", romanNumbersConverter.convert(2));
        assertEquals("III", romanNumbersConverter.convert(3));
        assertEquals("IV", romanNumbersConverter.convert(4));
        assertEquals("V", romanNumbersConverter.convert(5));
        assertEquals("VI", romanNumbersConverter.convert(6));
        assertEquals("VII", romanNumbersConverter.convert(7));
        assertEquals("VIII", romanNumbersConverter.convert(8));
        assertEquals("IX", romanNumbersConverter.convert(9));
        assertEquals("X", romanNumbersConverter.convert(10));
        assertEquals("XI", romanNumbersConverter.convert(11));
        assertEquals("XII", romanNumbersConverter.convert(12));
        assertEquals("XIII", romanNumbersConverter.convert(13));
        assertEquals("XIV", romanNumbersConverter.convert(14));
        assertEquals("XV", romanNumbersConverter.convert(15));
        assertEquals("XVI", romanNumbersConverter.convert(16));
        assertEquals("XVII", romanNumbersConverter.convert(17));
        assertEquals("XVIII", romanNumbersConverter.convert(18));
    }
}
