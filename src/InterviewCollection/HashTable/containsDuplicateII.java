package InterviewCollection.HashTable;

import java.util.HashMap;

public class containsDuplicateII {

    public static void main(String[] args) {
//        int[] nums = {1, 0, 1, 1};
//        int k = 1;

        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;

//        int[] nums = {1,1};
//        int k = 2;

        System.out.println("Output : " + containsNearbyDuplicate(nums, k));
    }

    /*
        Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
     */

    private static boolean containsNearbyDuplicate(int[] nums, int k) {

        if (nums == null || nums.length == 1) return false;
        if (nums.length == 2 && nums[0] == nums[1] && k <= 1) return true; // will be tested


        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            var key = nums[i];
            if (map.containsKey(key)) {

                if (Math.abs(i - map.get(key)) <= k)
                    return true;
                else {
//                    map.put(key,i);
                    map.replace(key, i);
                }
            }else {
                map.put(key,i);
            }
        }
        return false;
    }
}
