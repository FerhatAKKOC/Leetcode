package InterviewCollection.Amazon;

import java.util.Arrays;

public class productOfArrayExceptSelf {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        var output = productExceptSelf(nums);
        Arrays.stream(output).forEach(value -> System.out.print(value + " "));
    }

    /*
        Product of Array Except Self
     */

    private static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] output = new int[n];
        int[] right = new int[n];
        output[0] = nums[0];

        for (int i = 1; i < n; i++) {
            output[i] = output[i - 1] * nums[i];
        }

        int product = 1;

        for (int i = n - 1; 0 < i; i--) {
            output[i] = product * output[i - 1];
            product *= nums[i];
        }
        output[0] = product;

        return output;
    }

    //****************************************************
    //****************************************************
    private static int[] productExceptSelf2(int[] nums) {

        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        right[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i];
        }

        for (int i = n - 2; 0 <= i; i--) {
            right[i] = right[i + 1] * nums[i];
        }

        for (int i = 0; i < n; i++) {
            if (i - 1 < 0)
                nums[i] = right[i + 1];
            else if (i + 1 >= n)
                nums[i] = left[i - 1];
            else
                nums[i] = left[i - 1] * right[i + 1];
        }

        return nums;
    }
}
