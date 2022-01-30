package InterviewCollection.Recursions;

public class printReverse {

    public static void main(String[] args) {

        printReverse("Ferat AKKOÇ".toCharArray());
    }

    private static void printReverse(char [] str) {
        helper(0, str);
    }

    private static void helper(int index, char [] str) {
        if (str == null || index >= str.length) {
            return;
        }
        helper(index + 1, str);
        System.out.print(str[index]);
    }
}
