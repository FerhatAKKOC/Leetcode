package InterviewCollection.Amazon;

import java.util.*;
import java.util.stream.Collectors;

public class threeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        var output = threeSum2(nums);

        for (var out : output)
            System.out.println(out);

    }

    /*
            Approach 1: Two Pointers
     */
    private static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();

        if (nums.length == 0 || (nums.length == 1 && nums[0] == 0))
            return list;

        Arrays.sort(nums); // Mutlaka sorted olmalı.
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) { // If the current value is greater than zero, break from the loop. Remaining values cannot sum to zero.
            if (i == 0 || nums[i - 1] != nums[i])                   // If the current value is the same as the one before, skip it.
                twoSum_(nums, i, list);
        }
        return list;
    }

    private static void twoSum_(int[] nums, int i, List<List<Integer>> list) {

        int lo = i + 1;
        int hi = nums.length - 1;

        while (lo < hi) {

            int sum = (nums[i] + nums[lo] + nums[hi]);

            if (sum < 0) {
                lo++;
            } else if (sum > 0) {
                hi--;
            } else {
                list.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                while (lo < hi && nums[lo - 1] == nums[lo])  // skip for triplet dublication
                    lo++;
            }
        }
    }

    /*
      Brute Force Solution
     */
    private static List<List<Integer>> threeSum2(int[] nums) {

        Set<List<Integer>> dups = new HashSet<>();

        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (i != j && i != k && j != k)
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            List<Integer> sorted = Arrays.asList(nums[i], nums[j], nums[k]);
                            Collections.sort(sorted);
                            dups.add(sorted);
                        }
                }

            }
        }

        return dups.stream().collect(Collectors.toList());

    }


}
