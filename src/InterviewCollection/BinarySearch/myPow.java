package InterviewCollection.BinarySearch;

public class myPow {

    public static void main(String[] args) {
        System.out.println("Output : " + myPow(2.1, 3));
    }

    //****************************************************************
    //     Recursive solutions
    //****************************************************************
    private static double myPow(double x, int n) {

        var res = helper(x, Math.abs(n));

        if (n < 0)
            return 1 / res;
        return res;
    }

    private static double helper(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;

        return x * helper(x, n - 1);
    }
}
