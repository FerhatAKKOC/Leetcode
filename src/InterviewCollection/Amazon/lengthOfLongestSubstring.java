package InterviewCollection.Amazon;

import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubstring {

    public static void main(String[] args) {

        String s = "pwwkew";

        System.out.println("Output: " + lengthOfLongestSubstring(s));
    }

    private static int lengthOfLongestSubstring(String s) {

        if (s.length() == 0)
            return 0;

        int maxSize = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();

        int slow = 0;
        for (int fast = 0; fast < s.length(); ) {

            if (set.contains(s.charAt(fast))) {
                set.remove(s.charAt(slow++));    // s.charAt(fast) remove edene kadar buraya hit ediyor.
            } else {
                set.add(s.charAt(fast++));
                fast++;
                if (set.size() > maxSize)
                    maxSize = set.size();
            }
        }

        return maxSize;
    }
}
