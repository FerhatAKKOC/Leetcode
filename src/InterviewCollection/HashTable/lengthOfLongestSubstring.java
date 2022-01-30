package InterviewCollection.HashTable;

import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "abcaabcbb";

        System.out.println("Output : " + lengthOfLongestSubstring(s));
    }

    private static int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        Set<Character> set = new HashSet<>();

        int slow = 0, fast = 0, max = Integer.MIN_VALUE;

        while (fast < s.length()) {
            if (!set.contains(s.charAt(fast))) {
                set.add(s.charAt(fast++));
                max = Math.max(max, fast - slow);
            } else {
                set.remove(s.charAt(slow++));
            }
        }
        return max;
    }
}
