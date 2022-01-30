package InterviewCollection.QueueStack;

import java.util.ArrayList;
import java.util.List;

public class TargetSum {

    public static void main(String[] args) {


    }
    private static int findTargetSumWays2(int[] nums, int target) {

        if (nums == null) return 0;
        if (nums.length == 1 && nums[0] == target) return 1;

        return helper(nums, 0, target, new ArrayList<>());

    }

    private static int counter = 0;

    private static int helper(int[] nums, int i, int target, List<Integer> list) {

        if (list.size() == nums.length) {
            Integer sum = list.stream().reduce(0, Integer::sum);
            if (sum == target){
                counter++;
                return counter;
            }
        }

        for (int j = 0; j < 2 && i<nums.length ; j++) {
            int val = j == 0 ? nums[i] : -nums[i];
            list.add(val);
            helper(nums, i + 1, target, list);
            list.remove(list.size() - 1);
        }

        return counter;
    }

}

//******************************************************************
//******************************************************************
//      Brute Force Solution

class Solution {
    int count = 0;

    public int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return count;
    }

    public void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S)
                count++;
        } else {
            calculate(nums, i + 1, sum + nums[i], S);
            calculate(nums, i + 1, sum - nums[i], S);
        }
    }
}