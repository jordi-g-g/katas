package com.codurance.kata.romannumbers;

public class RomanNumbersConverter {
    public static String convert(int i) {
        StringBuilder output = new StringBuilder();
        while (i >= 1) {
            output.append("I");
            i--;
        }
        return output.toString();
    }
}
