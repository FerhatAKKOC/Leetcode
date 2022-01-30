package InterviewCollection.ArrayStrings;

public class ReverseWordsIInAString {
    public static void main(String[] args) {

        String s = "  Alice does not even like bob  ";

        System.out.println(s);
        System.out.println(reverseWords(s));
    }

    /*
        Input: s = "Alice does not even like bob"
        Output: "bob like even not does Alice"
     */
    private static String reverseWords(String s) {

        var splits = s.trim().split(" ");
        int p1 = 0;
        int p2 = splits.length - 1;

        while (p1 < p2){
            String temp = splits[p1];
            splits[p1] = splits[p2];
            splits[p2] = temp;
            p1++;
            p2--;
        }
        return String.join(" ", splits);
    }
}
