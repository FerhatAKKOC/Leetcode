package InterviewCollection.CollectionsMedium;

public class titleToNumber {

    public static void main(String[] args) {

        System.out.println("Output: " + titleToNumber("A"));
        System.out.println("Output: " + titleToNumber("AB"));
        System.out.println("Output: " + titleToNumber("ZY"));
        System.out.println("Output: " + titleToNumber("FXSHRXW"));

    }

    // Normal işlemlerimizi base10 tabanında yapıyorken, burada base 26 tabanında yapmalıyız.
    private static int titleToNumber(String title) {

        int sum = 0;

        int digit = 0;

        for (int i = title.length() - 1; 0 <= i; i--) {
            sum += convert26To10(title.charAt(i)) * (int) Math.pow(26, digit++);
        }

        return sum;
    }

    //@:64, A:65
    private static int convert26To10(char ch) {
        return (ch - '@');
    }
}
