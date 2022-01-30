package InterviewCollection.CollectionsMedium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lengthOfLongestSubstring {

    public static void main(String[] args) {

        System.out.println("Output: " + lengthOfLongestSubstring("pwwkew"));
    }

    private static int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        Set<Character> set = new HashSet<>();

        int slow = 0, fast = 0, max = Integer.MIN_VALUE;

        while (fast < s.length()) {

            if (set.contains(s.charAt(fast))) {
                set.remove(s.charAt(slow));
                slow++;
            } else {
                set.add(s.charAt(fast));
                fast++;
                max = Math.max(max, fast - slow);
            }
        }
        return max;
    }
}
