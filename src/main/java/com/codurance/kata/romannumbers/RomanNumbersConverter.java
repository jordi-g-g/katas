package com.codurance.kata.romannumbers;

public class RomanNumbersConverter {
    public static String convert(int i) {
        StringBuilder output = new StringBuilder();
        if (i > 3) {
            output.append("V");
            i = (5 - i);
        }
        while (i >= 1) {
            output.append("I");
            i--;
        }
        return output.reverse().toString();
    }
}
