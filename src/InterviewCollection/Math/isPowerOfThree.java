package InterviewCollection.Math;

public class isPowerOfThree {

    public static void main(String[] args) {
        System.out.println("Result : " + isPowerOfThree(3));
    }


    private static boolean isPowerOfThree(int n) {

        for (int i = 1; i <= n; i++) {
            var temp = Math.pow(3, i);
            if (n == temp) {
                return true;
            }
            if (temp > n)
                break;
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
