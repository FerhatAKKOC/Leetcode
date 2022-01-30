package InterviewCollection.BinarySearch;

public class FindPeakElement {
    public static void main(String[] args) {

//        int[] nums = {1, 2, 3, 1};
        int[] nums = {1,2,1,3,5,6,4};

        System.out.println("Output : " + findPeakElement(nums));

    }

    /*
        A peak element is an element that is strictly greater than its neighbors.
        Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
        You may imagine that nums[-1] = nums[n] = -∞.
        You must write an algorithm that runs in O(log n) time
     */

    private static int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length;

        while (left < right) {

            int midpoint = left + (right - left) / 2;

            if (midpoint == 0 || nums[midpoint + 1] < nums[midpoint])
                return midpoint;
            else if (nums[0] < nums[midpoint])
                left = midpoint + 1;
            else
                right = midpoint;
        }

        return left;

    }
}
