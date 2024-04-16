package com.codurance.kata.romannumbers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RomanNumbersConverter {

    private final Map<Integer, String> romanMapping;

    public RomanNumbersConverter() {
        romanMapping = new TreeMap<>(Comparator.reverseOrder());
        romanMapping.put(5, "V");
        romanMapping.put(10, "X");
    }

    public String convert(int i) {
        StringBuilder output = new StringBuilder();

        for (Map.Entry<Integer, String> entry : romanMapping.entrySet()) {
            if (i == entry.getKey() - 1) {
                output.append("I");
                output.append(entry.getValue());
                i = (i - entry.getKey());
            }
            if (i >= entry.getKey()) {
                output.append(entry.getValue());
                i = (i - entry.getKey());
            }
        }

        while (i >= 1) {
            output.append("I");
            i--;
        }
        return output.toString();
    }
}
