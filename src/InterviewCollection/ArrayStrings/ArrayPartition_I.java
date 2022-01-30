package InterviewCollection.ArrayStrings;

import java.util.Arrays;

public class ArrayPartition_I {

    public static void main(String[] args) {
        int[] nums = {6, 2, 6, 5, 1, 2};
        System.out.println("Output : " + arrayPairSum(nums));
    }

    /*
    Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn)
    such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.
    Input: nums = [6,2,6,5,1,2] Output: 9
    Explanation: The optimal pairing is (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9.
     */
    private static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int total = 0;

        for (int i = 0; i < n; i += 2) {
            total += Math.min(nums[i], nums[i + 1]);
        }
        return total;
    }
}
