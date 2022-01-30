package InterviewCollection.Amazon;

import java.util.HashMap;
import java.util.Map;

public class romanToInteger {

    private static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        System.out.println("Output: " + romanToInt("MCMXCIV"));


    }

    /* Roman To Integer */
    private static int romanToInt(String s) {

        int n = s.length();
        int total = 0;

        total = map.get(s.charAt(n - 1));
        for (int i = n - 2; 0 <= i; i--) {

            char ch = s.charAt(i);
            char prev = s.charAt(i + 1);

            if (ch == 'I' && (prev == 'V' || prev == 'X'))
                total -= map.get(ch);
            else if (ch == 'X' && (prev == 'L' || prev == 'C'))
                total -= map.get(ch);
            else if (ch == 'C' && (prev == 'D' || prev == 'M'))
                total -= map.get(ch);
            else
                total += map.get(ch);
        }

        return total;
    }

    //******************************************************
    private static int romanToInt2(String s) {

        int sum = 0;
        int i = 0;

        while (i < s.length()) {
            char currentSymbol = s.charAt(i);
            int currentValue = map.get(currentSymbol);
            int nextValue = 0;
            if (i + 1 < s.length()) {
                char nextSymbol = s.charAt(i + 1);
                nextValue = map.get(nextSymbol);
            }

            if (currentValue < nextValue) {
                sum += (nextValue - currentValue);
                i += 2;
            } else {
                sum += currentValue;
                i += 1;
            }

        }
        return sum;
    }
}
