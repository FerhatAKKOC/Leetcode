package InterviewCollection.Math;

import java.util.HashMap;
import java.util.Map;

public class romanToInt {

    public static void main(String[] args) {
        String s = "MCMXCIV";
        romanToInt(s);
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

        int total  = map.get(s.charAt(s.length()-1));

        for (int i = s.length() - 2; 0 <= i; i--) {

            int second = map.get(s.charAt(i));
            int first = map.get(s.charAt(i + 1));

            if(second<first)
                total -= second;
            else
                total += second;
        }

        System.out.println("Total : " + total);
        return total;
    }
}
