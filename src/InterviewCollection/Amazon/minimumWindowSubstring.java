package InterviewCollection.Amazon;

import java.util.HashMap;
import java.util.Map;

public class minimumWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";

        System.out.println("Output: " + minWindow(s, t));
    }

    /*
        https://www.youtube.com/watch?v=eS6PZLjoaq8
     */
    private static String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0)
            return "";

        Map<Character, Integer> mapT = new HashMap<>();

        for (var ch : t.toCharArray()) {
            mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
        }

        int required = mapT.size(); //3
        int isReqired = 0;

        int l = 0, r = 0;

        Map<Character, Integer> mapWindow = new HashMap<>();

        int[] check = {-1, l, r}; // at beginning, win size = 0;

        while (r < s.length()) {

            var ch = s.charAt(r);

            mapWindow.put(ch, mapWindow.getOrDefault(ch, 0) + 1);

            if (mapT.containsKey(ch))
                if (mapWindow.get(ch) == mapT.get(ch))
                    isReqired++;

            while (l <= r && required == isReqired) {

                if (check[0] == -1 || r - l + 1 < check[0]) {
                    check[0] = r - l + 1;
                    check[1] = l;
                    check[2] = r;
                }

                ch = s.charAt(l);
                mapWindow.put(ch, mapWindow.getOrDefault(ch, 0) - 1);

                if (mapT.containsKey(ch))
                    if (mapWindow.get(ch) < mapT.get(ch))
                        isReqired--;
                l++;
            }
            r++;
        }

        return (check[0] == -1) ? "" : s.substring(check[1], check[2] + 1);
    }
}
