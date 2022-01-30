package InterviewCollection.BinarySearch;

public class isPerfectSquare {

    public static void main(String[] args) {

        System.out.println("Output : " + isPerfectSquare(1));
    }

    private static boolean isPerfectSquare(int num) {

        // x*x = num;
        // sqrt
        //[1,2,3,4......16] target = 4

        int left = 0;
        int right = num;
        int mid = -1;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if ((mid * mid) == num)
                break;
            else if ((mid * mid) < num)
                left = mid + 1;
            else
                right = mid - 1;
        }


        System.out.println("Middle : " + mid);

        if ((mid * mid) == num) return true;

        return false;
    }
}
