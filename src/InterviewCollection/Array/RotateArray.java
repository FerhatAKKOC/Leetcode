package InterviewCollection.Array;

import java.util.ArrayList;

public class RotateArray {

    public static void main(String[] args) {

//        Input: nums = [1,2,3,4,5,6,7], k = 3
//        Output: [5,6,7,1,2,3,4]


        int k = 3;
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};

        //rotate(nums, k);
        rotatebyOne(nums);


    }

    // leftRotateByOne -> LeftRotate
    // Create a new Array and copy one by one

    public static void rotate(int[] nums, int k) {

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = k + 1; i < nums.length; ) {   // Dikkat et, i'yi içeride arttır.

            arr.add(nums[i]);
            i++;
            if (i == nums.length)
                i = 0;
            if (i == k + 1)
                break;
        }
        System.out.println(arr);
    }

    public static void rotatebyOne(int[] nums) {

        if (nums.length == 0 || nums == null)
            return;

        int beginning = nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
        nums[nums.length-1] = beginning;

        for (var i : nums)
            System.out.print(" " + i);
    }
}
