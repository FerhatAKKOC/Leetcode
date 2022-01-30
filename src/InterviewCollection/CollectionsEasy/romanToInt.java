package InterviewCollection.CollectionsEasy;

import java.util.HashMap;
import java.util.Map;

public class romanToInt {

    public static void main(String[] args) {
        System.out.println("Output: " + romanToInt("MCMXCIV"));
    }

    private static int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int n = s.length() - 1;

        int total = map.get(s.charAt(n));

        for (int i = n - 1; 0 <= i; i--) {
            var first = map.get(s.charAt(i + 1));
            var second = map.get(s.charAt(i));

            if (second < first)
                total -= second;
            else
                total += second;
        }

        return total;
    }
}
