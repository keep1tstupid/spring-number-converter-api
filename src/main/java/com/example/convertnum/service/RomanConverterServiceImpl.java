package com.example.convertnum.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class RomanConverterServiceImpl implements RomanConverterService {
    private static final HashMap<Character, Integer> romanToArabic = new HashMap<>() {{
        put('i', 1);
        put('v', 5);
        put('x', 10);
        put('l', 50);
        put('c', 100);
        put('d', 500);
        put('m', 1000);
    }};

    public String prepareString(String receivedNum) {
        return receivedNum.toLowerCase().trim();
    }

    // checks that letters representing numbers starting with 1 can be repeated max 3 times
    // in row, letters representing numbers starting with 5 (v, l, d) - only once
    public boolean checkInvalidRepetitions(String romanNum) {
        int counter = 0;
        boolean validity = true;
        char prev = romanNum.charAt(0);

        for (int i = 1; i < romanNum.length(); i++) {
            if (validity) {
                char curr = romanNum.charAt(i);
                if (curr == prev) {
                    counter++;
                } else {
                    counter = 0;
                }
                validity = counter < ("vld".indexOf(curr) >= 0 ? 1 : 3);
                prev = curr;
            }
        }
        return validity;
    }

    public boolean validateRoman(String receivedNum) {
        String romanNum = prepareString(receivedNum);

        return romanNum.length() >= 1
                && romanNum.matches("[ivxlcdm]+")
                && checkInvalidRepetitions(romanNum);
    }

    public int convert(String value) {
        StringBuilder romanNum = new StringBuilder(value);
        romanNum.reverse();
        char firstVal = romanNum.charAt(0);
        int currentVal = romanToArabic.get(firstVal);
        int result = currentVal;

        if (romanNum.length() != 1) {
            for (int i = 1; i < romanNum.length(); i++) {
                char nextChar = romanNum.charAt(i);
                int nextVal = romanToArabic.get(nextChar);
                if (currentVal < nextVal || currentVal == nextVal) {
                    result += nextVal;
                } else {
                    result -= nextVal;
                }
                currentVal = nextVal;
            }
        }
        return result;
    }
}