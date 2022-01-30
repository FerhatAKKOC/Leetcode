package InterviewCollection.Amazon;

public class longestPalindrome {

    public static void main(String[] args) {
        System.out.println("Output: " + longestPalindrome("babad"));
        System.out.println("Output: " + longestPalindrome("cbbd"));
        System.out.println("Output: " + longestPalindrome("ac"));
        System.out.println("Output: " + longestPalindrome("a"));
    }

    /*
        Longest Palindromic Substring
        https://www.youtube.com/watch?v=XYQecbcd6_c
        Note: Her bir harfi içeriden her iki yana doğru tarıyoruz. O(n^2)
     */
    private static String longestPalindrome(String s) {

        String maxPolindrome = new String();

        for (int i = 0; i < s.length(); i++) {
            var temp = getMaxPolindrom(s, i);
            if (temp.length() > maxPolindrome.length())
                maxPolindrome = temp;
        }

        return maxPolindrome;
    }

    private static String getMaxPolindrom(String str, int index) {

        int left = index - 1;
        int rigth = index + 1;

        String result = String.valueOf(str.charAt(index));

        while (0 <= left && rigth < str.length()) {
            if (str.charAt(left) == str.charAt(rigth)) {
                result = str.substring(left, rigth + 1);
                left--;
                rigth++;
            } else if (str.charAt(index) == str.charAt(rigth)) {  // "cbbd" içerisindeki 'bb' yakalayıp, öyle kırıyor.
                result = str.substring(index, rigth + 1);
                break;
            } else {
                break;
            }
        }

        return result;
    }
}
