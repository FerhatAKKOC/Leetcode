package InterviewCollection.CollectionsHard;

import java.util.Arrays;
import java.util.Collections;

public class maximumProductSubarray {

    public static void main(String[] args) {
//        int[] nums = {2, 3, -2, 4};
        int[] nums = {-2, 0, -1};

        System.out.println("Output: " + maxProduct(nums));

    }

    /*
        Maximum Product Subarray
        https://www.youtube.com/watch?v=lXVy6YWFcRM
     */
    private static int maxProduct(int[] nums) {


        int global_max = Arrays.stream(nums).max().getAsInt();

        int curr_max = 1;
        int curr_min = 1;

        for (var n : nums) {

            if (n == 0) curr_max = curr_min = 1;

            int temp_max = curr_max * n;
            int temp_min = curr_min * n;
            curr_max = Collections.max(Arrays.asList(temp_max, temp_min, n));  // max(currMax, currMin, n)
            curr_min = Collections.min(Arrays.asList(temp_max, temp_min, n));  // min(currMax, currMin, n)

            global_max = Math.max(global_max, curr_max);
        }

        return global_max;
    }
}
