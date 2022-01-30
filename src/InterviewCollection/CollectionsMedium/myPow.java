package InterviewCollection.CollectionsMedium;

public class myPow {

    public static void main(String[] args) {
        System.out.println("Output: " + myPow(2.0, -2));
        System.out.println("Output : " + myPow(2.1, 3));
    }

    private static double myPow(double x, int n) {

        var result = helper(x, Math.abs(n));

        if (n < 0) return 1 / result;  // negative 'n' için

        return result;
    }

    private static double helper(double x, int n) {

        if (n == 0) return 1;
        if (n == 1) return x;

        return x * myPow(x, n - 1);
    }
}
