package InterviewCollection.Array;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
//        System.out.println(isPolindrom("a"));
//
//        var name = "Ferat";
//        System.out.println(name.substring(0,name.length()-1));

        System.out.println("Output : " + longestPalindrome("babad"));
    }

    /*
        Input: s = "babad"
        Output: "bab"
        Note: "aba" is also a valid answer.
     */
    private static String longestPalindrome(String s) {

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                var ch = s.substring(i, j);
                if (ch.length() > 1 && isPolindrom(ch))
                    return ch;
            }
        }

        return String.valueOf(s.charAt(0));
    }


    private static boolean isPolindrom(String s) {

        System.out.println("isPolindrom: " + s);

        if (s.length() == 1) return true;
        if (s.length() == 2) return s.charAt(0) == s.charAt(1);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(s.length() - i))
                return false;
        }
        return true;
    }

}
