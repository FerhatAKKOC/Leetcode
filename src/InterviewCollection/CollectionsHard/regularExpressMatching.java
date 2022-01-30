package InterviewCollection.CollectionsHard;

public class regularExpressMatching {

    public static void main(String[] args) {

    }

    /*
        Regular Expression Matching
        https://www.youtube.com/watch?v=l3hda49XcDE
     */
    private static boolean isMatch(char[] str, char[] pattern) {

        boolean[][] DP = new boolean[str.length + 1][pattern.length + 1];
        DP[0][0] = true;

        // deal with patterns a*, a*b*, a*b*c*
        for (int i = 1; i < DP[0].length; i++) {  // first row
            if (pattern[i - 1] == '*')
                DP[0][i] = DP[0][i - 2];  // Ilk row'da '*' olan yerler TRUE ile dolduruluyor.
        }

        for (int i = 1; i < DP.length; i++) {
            for (int j = 1; j < DP[0].length; j++) {

                if (pattern[j - 1] == str[i - 1] || pattern[j - 1] == '.')
                    DP[i][j] = DP[i - 1][j - 1];
                else if (pattern[j - 1] == '*') {
                    DP[i][j] = DP[i][j - 2];

                    if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.')  // '*'dan bir önceki karakter ile str'deki karakter aynı mı?, yada bir önceki '.' mı?
                        DP[i][j] = DP[i][j] | DP[i - 1][j];  // up cell ile karşılaştırıyoruz.
                }
            }
        }

        return DP[str.length][pattern.length]; // son hücreyi dönüyoruz.
    }
}
