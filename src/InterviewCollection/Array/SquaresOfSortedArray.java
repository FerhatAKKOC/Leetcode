package InterviewCollection.Array;

import java.util.Arrays;

public class SquaresOfSortedArray {

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};

        for (var a : nums) {
            System.out.print(a + " ");
        }
        System.out.println();
        var output = sortedSquares(nums);

        for (var a : output) {
            System.out.print(a + " ");
        }
    }

    /*
        Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
        Input: nums = [-4,-1,0,3,10]
        Output: [0,1,9,16,100]
     */
    private static int[] sortedSquares(int[] nums) {

        int n = nums.length;
        int[] arr = new int[n];

        int start = 0;
        int end = n - 1;

        for (int i = n - 1; i > 0; i--) {
            if (Math.abs(nums[start]) > Math.abs(nums[end])) {
                arr[i] = nums[start] * nums[start];
                start++;
            } else {
                arr[i] = nums[end] * nums[end];
                end--;
            }
        }

        return arr;
    }
}
