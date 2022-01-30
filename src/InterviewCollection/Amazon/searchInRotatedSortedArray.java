package InterviewCollection.Amazon;

public class searchInRotatedSortedArray {

    public static void main(String[] args) {

        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 2;

        System.out.println("Output: " + search(nums, target));
    }

    /*
    1. Find a rotation index rotation_index, i.e. index of the smallest element in the array. Binary search works just perfect here.
    2. rotation_index splits array in two parts. Compare nums[0] and target to identify in which part one has to look for target.
    3. Perform a binary search in the chosen part of the array.
     */
    private static int search(int[] nums, int target) {

        int pivot = find_pivot(nums);

        if (nums[pivot] == target) return pivot;

        int left = 0;
        int right = nums.length - 1;

        if (nums[pivot] <= target && target <= nums[right])
            left = pivot;
        else
            right = pivot;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (target < nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }

        return -1;
    }

    private static int find_pivot(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        if (arr[left] < arr[right]) // there is no shifting
            return 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (mid == 0 || arr[mid - 1] > arr[mid])
                return mid;
            else if (arr[0] < arr[mid]) // left side is regular
                left = mid + 1;
            else
                right = mid - 1;
        }
        return 0;
    }
}
