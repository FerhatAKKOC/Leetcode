package InterviewCollection.Amazon;

import java.util.HashMap;
import java.util.Map;

public class firstUniqChar {

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println("Output: " + firstUniqChar(s));
    }

    private static int firstUniqChar(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (var ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1)
                return i;
        }

        return -1;
    }
}
