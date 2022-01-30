package InterviewCollection.Array;

import java.util.*;
import java.util.stream.Collectors;

public class FindDisappearedNumber {

    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        var output = findDisappearedNumbers(nums);

        System.out.println(output);
    }
    /*
        Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
        Input: nums = [4,3,2,7,8,2,3,1]
        Output: [5,6]
     */

    private static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new ArrayList<>();

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }

        return list;
    }
}

