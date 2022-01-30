package InterviewCollection.Amazon;

import javax.print.attribute.SetOfIntegerSyntax;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreak {

    public static void main(String[] args) {

        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");

        String s = "catsanddog"; // catsandog

        System.out.println("Output: " + wordBreak(s, wordDict));

    }


    private static boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);

        return wordBreak(s, 0, set);
    }

    /*
        Recurive
     */
    private static boolean wordBreak(String s, int index, Set<String> set) {

        // base case.
        if (index == s.length())
            return true;

        StringBuilder sb = new StringBuilder();

        for (int i = index; i < s.length(); i++) {

            char ch = s.charAt(i);
            sb.append(ch);

            if (set.contains(sb.toString())) {
                boolean res = wordBreak(s, i + 1, set);

                if (res) return true;
            }
        }
        return false;
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
                    DP[i] = DP[i + word.length()]; // DP[0] = DP[0+4] Mesala eğer DP[4] false, DP[0]'da false olacak.
                                                    // Çünkü bu demektirki i=0'da bir kelime yakaladık fakat recurive edersek i=4 ten sonra kelime yakalayamadık
                }                                   // Aşağıdan yukarı bir gidiş var.
                if (DP[i] == true)
                    break;
            }
        }

        return DP[0];
    }

}
