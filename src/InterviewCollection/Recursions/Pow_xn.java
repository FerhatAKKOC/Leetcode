package InterviewCollection.Recursions;

public class Pow_xn {

    public static void main(String[] args) {

        System.out.println("Output: " + myPow(2.0, -2));
    }

    private static double myPow(double x, int n) {

        if (n == 0)
            return 1;
        if (n < 0) {
            n = -n; // negative sayılar için
            x = 1 / x;
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
