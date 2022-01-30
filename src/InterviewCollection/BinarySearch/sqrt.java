package InterviewCollection.BinarySearch;

public class sqrt {

    public static void main(String[] args) {

        System.out.println("Output : " + sqrt(8));
    }

    /*
     Look for the critical point: i * i <= x && (i+1)(i+1) > x

     Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.

     */
    private static int sqrt(int x) {

        if (x == 0) return 0;

        int left = 1, right = x;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if ((mid * mid) <= x && x < ((mid + 1) * (mid + 1)))// Found the result
                return mid;

            else if (x < (mid * mid))// Keep checking the left part
                right = mid;

            else
                left = mid + 1;// Keep checking the right part

        }

        return left;
    }

//*****************************************************

    public int mySqrt(int x) {
        if (x == 0) return 0;
        for (int i = 1; i <= x / i; i++)
            if ((i * i) <= x && x < ((i + 1) * (i + 1)))// Look for the critical point: i*i <= x && (i+1)(i+1) > x
                return i;

        return -1;
    }

}

