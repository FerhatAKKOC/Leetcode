package InterviewCollection.CollectionsHard;

public class wildcardMatching {

    public static void main(String[] args) {

        String s = "aaadceb", p = "*a*b";

        System.out.println("Output: " + isMatch(s, p));

    }

    /*
        Wildcard Matching
        https://www.youtube.com/watch?v=3ZDZ-N0EPV0
    */
    private static boolean isMatch(String s, String p) {

        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();

        /*  a**b***c -> a*b*c  */
        int writeIndex = 0;
        boolean isFirst = true;
        for (int i = 0; i < pattern.length; i++) {
            if (pattern[i] == '*') {
                if (isFirst) {
                    pattern[writeIndex++] = '*';
                    isFirst = false;
                }
            } else {
                pattern[writeIndex++] = pattern[i];
                isFirst = true;
            }
        }

        boolean DP[][] = new boolean[str.length + 1][writeIndex + 1];
        DP[0][0] = true;
        if (writeIndex > 0 && pattern[0] == '*') {  // first row: dp[0][j]: except for String p starts with *, otherwise all false
            DP[0][1] = true;
        }


        for (int i = 1; i < DP.length; i++) {

            for (int j = 1; j < DP[0].length; j++) {

                if (pattern[j - 1] == '?' || str[i - 1] == pattern[i - 1])  // karakter  yada '?' 'de diagnol'un değerini alıyoruz.
                    DP[i][j] = DP[i - 1][j - 1];
                else if (pattern[j - 1] == '*')
                    DP[i][j] = DP[i - 1][j] || DP[i][j - 1];
            }

        }


        return false;


    }

/*
    dp[i][j]: true if the first i char in String s matches the first j chars in String p

    Base case:
    origin: dp[0][0]: they do match, so dp[0][0] = true
    first row: dp[0][j]: except for String p starts with *, otherwise all false
    first col: dp[i][0]: can't match when p is empty. All false.

    Recursion:

    Iterate through every dp[i][j]
    dp[i][j] = true:
    if (s[ith] == p[jth] || p[jth] == '?') && dp[i-1][j-1] == true
    elif p[jth] == '*' && (dp[i-1][j] == true || dp[i][j-1] == true)
    -for dp[i-1][j], means that * acts like an empty sequence.
    eg: ab, ab*
    -for dp[i][j-1], means that * acts like any sequences
    eg: abcd, ab*
    Start from 0 to len
    Output put should be dp[s.len][p.len], referring to the whole s matches the whole p
    Be careful about the difference of index i,j in String (0 to len-1) and the index i, j in dp (0 to len)!

     */
}
