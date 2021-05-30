package com.example.convertnum.service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;


@Service
public class ArabConverterServiceImpl implements ArabConverterService {

    private static final Map<Character, Integer> romanToArabic = new LinkedHashMap<>() {{
        put('m', 1000);
        put('d', 500);
        put('c', 100);
        put('l', 50);
        put('x', 10);
        put('v', 5);
        put('i', 1);
    }};

    //parse and check - number be an integer between 1 and 4000
    public int prepareNumber(String s) {
        int res = 0;
        try {
            int number = Integer.parseInt(s);
            if ( number > 0 && number < 4000 ) res = number;
        } catch (NumberFormatException ignored) {}
        return  res;
    }

    // makes roman number for 4/6/9 cases by combining previous roman numbers in the map
    public String handleExceptionalCases
            (int number, char curr, char prev, char prev2) {
        String res;
        if (number == 4) {
            res = "" + curr + prev;
        } else if (number == 6) {
            res = "" + prev + curr;
        } else {
            res = "" + curr + prev2;
        }
        //System.out.println("res is " + res);
        return res;
    }

    public String convert(int number) {
        int i = 0;
        StringBuilder sb = new StringBuilder();

        // 7 in this case is the length of romanToArabic map
        while (number > 0 && i < 7) {
            for (Map.Entry e : romanToArabic.entrySet()) {
                int n = number / (int) e.getValue();
                    if (number / (int) e.getValue() > 0) {
                        if (n == 4 || n == 6 || n == 9) {
                            char prev = (char) romanToArabic.keySet().toArray()[i - 1];
                            char prev2 = (char) romanToArabic.keySet().toArray()[i - 2];
                            sb.append(handleExceptionalCases(n, (char) e.getKey(), prev, prev2));
                        } else {
                            String curr = e.getKey().toString().repeat(n);
                            sb.append(curr);
                        }
                    }
                number = number - (int) e.getValue() * n;
                i++;
            }
        }
        return sb.toString().toUpperCase();
    }
}
