package InterviewCollection.Strings;

public class ReverseStrings {

    /*
        Input: s = ["h","e","l","l","o"]    Reverse String
        Output: ["o","l","l","e","h"]
     */

    public static void main(String[] args) {

        char[] s = {'h', 'e', 'l', 'l', 'o'};

        for (char c : s) System.out.print(c);
        reverseString(s);
        for (char c : s) System.out.print(c);
    }

    static void reverseString(char[] s) {

        int n = s.length;

        for (int i = 0; i < n / 2; i++) {
            char temp = s[i];
            s[i] = s[n - i - 1];
            s[n - i - 1] = temp;
        }
    }
}
