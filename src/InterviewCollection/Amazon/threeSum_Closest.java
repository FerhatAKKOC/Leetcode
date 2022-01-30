package InterviewCollection.Amazon;

import java.util.Arrays;

public class threeSum_Closest {

    public static void main(String[] args) {

        int[] nums = {-1, 2, 1, -4};
        int target = 1;

        System.out.println("Output: " + threeSumClosest(nums, target));
    }

    private static int threeSumClosest(int[] nums, int target) {

        int n = nums.length;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {

            int lo = i + 1;
            int hi = n - 1;

            int sum = nums[i] + nums[lo] + nums[hi];
            if (Math.abs(target - sum) < Math.abs(diff))
                diff = target - sum;

            if (sum < target)
                lo++;
            else if (sum > target)
                hi--;
            else
                break;
        }
        return target - diff;
    }
}
