package InterviewCollection.BinarySearch;

import java.util.Arrays;

public class Practice1 {

    public static void main(String[] args) {

//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        int[] nums = {3,4,5,1,2};
        int[] nums = {1,1,2};

        System.out.println("Output : " + findDuplicate(nums));

    }

    private static int findDuplicate(int[] arr) {

        Arrays.sort(arr);

        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1] == arr[i])
                return arr[i];
        }

        return -1;
    }

    private static int findMin(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        if (nums[0] < nums[nums.length - 1])
            return nums[0];


        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int middle = left + (right - left) / 2;

            if (nums[middle - 1] > nums[middle])
                return nums[middle];
            else if (nums[0] <= nums[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

}
