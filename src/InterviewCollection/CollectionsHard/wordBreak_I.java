package InterviewCollection.CollectionsHard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreak_I {

    public static void main(String[] args) {
        String s = "applepenapple";        List<String> wordDict = Arrays.asList("apple", "pen");
//        String s = "catsandog";     List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");


        System.out.println("Output: " + wordBreak2(s, wordDict));
    }

    private static boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);
        return wordBreak(s, 0, set);
    }

    private static boolean wordBreak(String s, int index, Set<String> set) {

        // base case.
        if (index == s.length())
            return true;

        StringBuilder sb = new StringBuilder();

        boolean flag = false;
        for (int i = index; i < s.length(); i++) {

            char ch = s.charAt(i);

            sb.append(ch);

            if (set.contains(sb.toString()))
                flag = wordBreak(s, i + 1, set);

            if (flag == true)
                break;

        }

        return flag;
    }

    //*******************************************************
    //*******************************************************
    // DP solution
    private static boolean wordBreak2(String s, List<String> wordDict) {

        int n = s.length();

        boolean[] DP = new boolean[n + 1];
        DP[n] = true;


        for (int i = n - 1; 0 <= i; i--) {
            for (var word : wordDict) {
                if (n >= i + word.length() && s.substring(i, i + word.length()).equals(word)) {
                    DP[i] = DP[i + word.length()];
                }
                if(DP[i] == true)
                    break;
            }
        }

        return DP[0];
    }


}














