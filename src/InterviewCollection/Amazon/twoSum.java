package InterviewCollection.Amazon;

import java.util.*;


public class twoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        var output = twoSum(nums, target);
        System.out.println("Output: " + output[0] + "  " + output[1]);
    }

    /* Two Sum */
    private static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.get(target - nums[i]) != null) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return null;
    }
}
