package InterviewCollection.BinarySearch;

public class SimpleBS {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 0;

        System.out.println("Output : " + search(nums, target));
    }

    /*
    Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums.
    If target exists, then return its index. Otherwise, return -1.
     */
    private static int search(int[] nums, int target) {

        if (nums == null) return -1;
        if (nums.length == 1 && nums[0] == target) return -1;

        int mid;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (nums[mid] == target)
                return mid;
            else if (target < nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }

        return -1;
    }
}
