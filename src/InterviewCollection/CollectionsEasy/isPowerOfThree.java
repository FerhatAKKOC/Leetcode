package InterviewCollection.CollectionsEasy;

import java.util.stream.IntStream;

public class isPowerOfThree {

    public static void main(String[] args) {


        System.out.println("Output: " + isPowerOfThree(27));
    }

    private static boolean isPowerOfThree(int n) {

        for (var val : IntStream.rangeClosed(1, n).toArray()) {

            if (Math.pow(val, 3) < n) continue;
            if (Math.pow(val, 3) == n) return true;
            if (Math.pow(val, 3) > n) break;
        }

        return false;
    }

    /*
        Time complexity: O(log3n)
        Space complexity: O(1)
     */
    private static boolean isPowerOfThree2(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}
