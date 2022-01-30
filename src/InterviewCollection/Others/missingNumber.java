package InterviewCollection.Others;

import java.util.Arrays;

public class missingNumber {

    public static void main(String[] args) {

        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};

        System.out.println("Output : " + missingNumber(nums));


    }

    /*
        Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
        Input: nums = [9,6,4,2,3,5,7,0,1]
        Output: 8
        Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
    */
    private static int missingNumber(int[] nums) {

        Arrays.sort(nums);

        if(nums[0] != 0) // ilk değere bakabiliriz.
            return 0;

        if (nums[nums.length - 1] != nums.length)  // son değeri karşılaştırabiliriz
            return nums.length;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != i)
                return i;
        }

        return -1;
    }
}
