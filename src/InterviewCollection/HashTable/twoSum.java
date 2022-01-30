package InterviewCollection.HashTable;

import java.util.Arrays;
import java.util.HashMap;

public class twoSum {

    public static void main(String[] args) {

        int[] nums = {2, 34, 13, 6, 1, 8, 7, 11, 15};
        int target = 35;

        Arrays.stream(twoSum(nums, target)).forEach(System.out::println);

    }

    private static int[] twoSum(int[] nums, int target) {

        if (nums.length < 2)
            return null;
        if (nums.length == 2 && (nums[0] + nums[1]) == target)
            return new int[]{0, 1};

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int temp = target - nums[i];

            if (map.containsKey(temp))
                return new int[]{map.get(temp), i};
            map.put(nums[i], i);
        }

        return null;
    }

}
