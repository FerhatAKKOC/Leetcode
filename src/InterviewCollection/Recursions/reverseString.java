package InterviewCollection.Recursions;

public class reverseString {

    public static void main(String[] args) {

        char[] s = {'h', 'e', 'l', 'l', 'o'};

//        reverseString(s);
        reverseStringRecursion(s);

    }

    private static void reverseString(char[] s) {

        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            var c = s[i];
            s[i] = s[j];
            s[j] = c;
            i++;
            j--;
        }
    }

    //**********************************************************************

    private static void reverseStringRecursion(char[] s) {
        helper(s, 0, s.length - 1);

        System.out.println(s);
    }

    private static void helper(char[] s, int left, int right) {

        // base case
        if (left >= right)
            return;

        char temp = s[right];
        s[right] = s[left];
        s[left] = temp;

        helper(s, ++left, --right);
    }


}
