package InterviewCollection.Amazon;

public class missingNumber {

    public static void main(String[] args) {

        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};

        System.out.println("Output: " + missingNumber(nums));
    }

    /*
        Missing Number
     */
    private static int missingNumber(int[] nums) {

        int size = nums.length;
        int sum = (size * (size + 1)) / 2;

        for (var val : nums)
            sum -= val;

        return sum;
    }
}
