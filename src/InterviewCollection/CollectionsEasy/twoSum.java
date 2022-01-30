package InterviewCollection.CollectionsEasy;

import java.util.HashMap;
import java.util.Map;

public class twoSum {

    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15}; int target = 9;
        int[] nums = {3, 2, 4};
        int target = 6;

        var output = twoSum(nums, target);

        System.out.println("Output: " + output[0] + " " + output[1]);

    }

    private static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        int[] arr = new int[2];

        map.put(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) {
                arr[0] = map.get(target - nums[i]);
                arr[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return arr;
    }
}
