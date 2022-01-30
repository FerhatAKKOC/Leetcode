package InterviewCollection.CollectionsEasy;

import java.util.HashMap;
import java.util.Map;

public class firstUniqueCharacterInString {

    public static void main(String[] args) {

        System.out.println(firstUniqChar("leetcode"));
    }

    /*
        Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
        Input: s = "loveleetcode"
        Output: 2
     */
    private static int firstUniqChar(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (var c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
