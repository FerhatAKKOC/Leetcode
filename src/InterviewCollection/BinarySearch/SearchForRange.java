package InterviewCollection.BinarySearch;

public class SearchForRange {

    public static void main(String[] args) {

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        var res = searchRange(nums, 10);

        for (var val : res)
            System.out.print(val + " ");

    }


    /*
    Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
    If target is not found in the array, return [-1, -1].
    You must write an algorithm with O(log n) runtime complexity.
    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]
     */
    private static int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0)
            return null;

        int left = 0;
        int right = nums.length - 1;

        int idx = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                idx = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (idx == -1) {
            return new int[]{-1, -1};
        } else {

            if (idx == 0 && nums[idx] == nums[idx + 1]) return new int[]{0, 1};
            else if (idx == nums.length - 1 && nums[idx - 1] == nums[idx])
                return new int[]{nums.length - 2, nums.length - 1};
            else {
                if (nums[idx] == nums[idx - 1]) return new int[]{idx - 1, idx};
                return new int[]{idx, idx + 1};
            }

        }
    }

    //*********************************************************
    public int[] searchRange2(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            if (nums[mid] == target) idx = mid;
        }
        return idx;
    }

    private int findLast(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            if (nums[mid] == target) idx = mid;
        }
        return idx;
    }
}
