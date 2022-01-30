package InterviewCollection.CollectionsMedium;

import java.util.*;
import java.util.stream.Collectors;

public class threeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        var outputs = threeSum(nums);

        for (var output : outputs) {
            for (var out : output)
                System.out.print(out + ", ");
            System.out.println();
        }

    }
    /*
        Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
        Notice that the solution set must not contain duplicate triplets. Sum3, sum 3
     */

    private static List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;

        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = i + 2; k < n; k++) {

                    if ((nums[i] + nums[j] + nums[k]) == 0) {

                        var list = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(list);
                        set.add(list);
                    }
                }
            }
        }

        return set.stream().collect(Collectors.toList());
    }
}


