package InterviewCollection.CollectionsEasy;

public class reverseInteger {

    public static void main(String[] args) {

        System.out.println("Output: " + reverseInteger(123));
    }

    private static int reverseInteger(int x) {

        StringBuilder sb = new StringBuilder(String.valueOf(x));
        sb.reverse();
        return Integer.valueOf(sb.toString());
    }
}
