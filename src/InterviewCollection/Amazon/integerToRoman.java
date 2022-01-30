package InterviewCollection.Amazon;

import java.util.HashMap;
import java.util.Map;

public class integerToRoman {

    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static void main(String[] args) {


        System.out.println("Output: " + intToRoman(3888)); // MMMDCCCLXXXVIII
    }

    /*  Integer to Roman */
    private static String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {

            while (values[i] <= num) {  // 71 sayısında her zaman 50 yi tercih ediyoruz. Küçük veya eşit, fakat en yakın
                sb.append(symbols[i]);
                num -= values[i];
            }
        }

        return sb.toString();
    }
}

/*
Time complexity : O(1)O(1).

As there is a finite set of roman numerals, there is a hard upper limit on how many times the loop can iterate.
This upper limit is 15 times, and it occurs for the number 3888, which has a representation of MMMDCCCLXXXVIII.
Therefore, we say the time complexity is constant, i.e. O(1)O(1).
 */
