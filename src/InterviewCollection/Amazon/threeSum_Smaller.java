package InterviewCollection.Amazon;

import java.util.Arrays;

public class threeSum_Smaller {

    public static void main(String[] args) {

        int[] nums = {-2, 0, 1, 3}; int target = 2;
//        int[] nums = {3,5,2,8,1}; int target = 7;

        System.out.println("Output: " + threeSumSmaller(nums, target));
    }

    /*
        3Sum Smaller
     */
    private static int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            sum += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return sum;
    }

    private static int twoSumSmaller(int[] nums, int startIndex, int target) {
        int sum = 0;
        int left = startIndex;
        int right = nums.length - 1;

        while (left < right) {

            if (nums[left] + nums[right] < target) {
                sum += right - left;
                left++;
            } else {
                right--;
            }
        }
        return sum;
    }
}
/*
Time complexity: O(n^2)O(n2). twoSumSmaller takes O(n)O(n) at most since it touches each element in the array once.
 It's parent function, threeSumSmaller takes O(n\log n)O(nlogn) to sort the array, then runs a loop that touches (n - 2)(n−2) elements,
 invoking twoSumSmaller at each iteration. Therefore, the overall time complexity is O(n\log n + n^2)O(nlogn+n
2), which boils down to O(n^2)O(n2).
 */
