package InterviewCollection.Strings;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FirstUniqueChar {

    /*
        Input: s = "leetcode"       Output: 0
        Input: s = "loveleetcode"   Output: 2
        Input: s = "aabb"           Output: -1
     */

    public static void main(String[] args) {

//        String s = "leetcode";
        String s = "loveleetcode";
//        String s = "aabb";

        var index = firstUniqChar1(s);
        System.out.println("index: " + index);
    }

    // Two for loops
    // Ordered Map
        /*
        I suggest a LinkedHashMap or a TreeMap. A LinkedHashMap keeps the keys in the order they were inserted,
         while a TreeMap is kept sorted via a Comparator or the natural Comparable ordering of the elements.
         */
    static int firstUniqChar(String s) {

        Map<Character, Integer> map = new LinkedHashMap<>();

        var charArray = s.toCharArray();

        for (char c : charArray) {

            if (map.containsKey(c)) {
                map.replace(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < charArray.length; i++) {
            if (map.get(charArray[i]) == 1) {
                return -1;
            }
        }

        return -1;
    }

    static int firstUniqChar1(String s) {

        Map<Character, Integer> map = new LinkedHashMap<>();

        var charArray = s.toCharArray();

        for (char c : charArray) {

            if (map.containsKey(c)) {
                map.replace(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        var res = map.entrySet().stream().filter(a -> a.getValue() == 1).collect(Collectors.toList());

        if (res.isEmpty())
            return -1;
        else {
            return s.indexOf(res.get(0).getKey());
        }
    }
}
