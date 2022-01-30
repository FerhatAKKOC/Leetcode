package InterviewCollection.BinarySearch;

public class RotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 2;

        System.out.println("Output : " + search(nums,target));
    }

    /*
        There is an integer array nums sorted in ascending order (with distinct values).
        Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
        Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
        You must write an algorithm with O(log n) runtime complexity.
     */
    private static int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) return -1;

        int start = pivot(nums);
        int left = 0;
        int right = nums.length - 1;

        if (nums[start] <= target && target <= nums[right]) // Değerimizi sağ tarafta arıyoruz.
            left = start;
        else {  // Değerimizi sol tarafta arıyoruz.
            right = start;
        }

        while (left <= right) {

            int midpoint = left + (right - left) / 2;

            if (nums[midpoint] == target)
                return midpoint;
            else if (nums[midpoint] < target)
                left = midpoint + 1;
            else
                right = midpoint - 1;
        }

        return -1;
    }


    /*
     {4, 5, 6, 7, 0, 1, 2};  bu array'de pivot point: 0  olan noktadır. Indeksi 4'tür.
     */
    private static int pivot(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        if (arr[left] < arr[right])
            return 0;

        /*
            Binary Search for '0'
         */
        while (left <= right) {

            int midpoint = left + (right - left) / 2;

            if (midpoint == 0 || arr[midpoint - 1] > arr[midpoint])
                return midpoint;
            else if (arr[0] < arr[midpoint])
                left = midpoint + 1;
            else
                right = midpoint - 1;
        }
        return 0;
    }
}
