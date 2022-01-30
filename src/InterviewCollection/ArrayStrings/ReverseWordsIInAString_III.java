package InterviewCollection.ArrayStrings;

public class ReverseWordsIInAString_III {
    public static void main(String[] args) {

        String s = "  Alice does not even like bob  ";

        System.out.println(s);
        System.out.println(reverseWords(s));

    }

    /*
        Input: s = "Let's take LeetCode contest"
        Output: "s'teL ekat edoCteeL tsetnoc"
     */
    private static String reverseWords(String s) {

        var splits = s.trim().split(" ");
        int p1 = 0;
        int p2 = splits.length - 1;

        while (p1 < p2) {
            String temp = splits[p1];
            splits[p1] = reverseString(splits[p2]);
            splits[p2] = reverseString(temp);
            p1++;
            p2--;
        }
        return String.join(" ", splits);
    }

    private static String reverseString(String str) {

        char[] s = str.toCharArray();
        int i = 0;
        int j = s.length - 1;

        while (i < j) {
            char temp = s[j];
            s[j] = s[i];
            s[i] = temp;

            i++;
            j--;
        }
        return String.valueOf(s);
    }

}
