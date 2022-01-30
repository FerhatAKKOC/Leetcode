package InterviewCollection.BinarySearch;

public class FindMinimuminRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int[] nums2 = {3, 4, 5, 1, 2};
        int[] nums3 = {11, 13, 15, 17};

        System.out.println("Output : " + findMin(nums));
    }

    private static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        
        // e.g. 1 < 2 < 3 < 4 < 5 < 7. Already sorted array.
        // Hence the smallest element is first element. A[0]
        if (nums[0] < nums[right]) { // if the last element is greater than the first element then there is no rotation.
            return nums[0];
        }

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid - 1] > nums[mid])   // if the mid element is lesser than its previous element then mid element is the smallest
                return nums[mid];
            if (nums[mid] > nums[mid + 1])
                return nums[mid];
            else if (nums[0] < nums[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }


}
