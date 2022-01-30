package InterviewCollection.CollectionsMedium;

import java.util.Arrays;
import java.util.Comparator;

public class findKthLargest {

    public static void main(String[] args) {
//        int[] nums = {3, 2, 1, 5, 6, 4}; int k = 2;
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6}; int k = 4;

        System.out.println("Output: " + findKthLargest(nums, k));
    }

    /*
        Given an integer array nums and an integer k, return the kth largest element in the array.
        Note that it is the kth largest element in the sorted order, not the kth distinct element.
     */
    private static int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        int size = nums.length;
        return nums[size - k];
    }
}
