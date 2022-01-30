package InterviewCollection.ArrayStrings;

public class ReverseString {

    public static void main(String[] args) {

        char[] s = {'h', 'e', 'l', 'l', 'o' };
        System.out.println(s);
        reverseString(s);
        System.out.println(s);
    }

    private static void reverseString(char[] s) {

        int i = 0;
        int j = s.length - 1;

        while (i < j) {
            char temp = s[j];
            s[j] = s[i];
            s[i] = temp;

            i++;
            j--;
        }
    }
}
