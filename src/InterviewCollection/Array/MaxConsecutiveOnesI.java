package InterviewCollection.Array;

public class MaxConsecutiveOnesI {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 1, 0, 1, 1, 1};
//        int[] nums = new int[]{1, 0, 1, 1, 0, 1};
        System.out.println("Output : " + findMaxConsecutiveOnes_I(nums));

    }

    /*
        Given a binary array nums, return the maximum number of consecutive 1's in the array.

        Input: nums = [1,1,0,1,1,1]
        Output: 3

        Input: nums = [1,0,1,1,0,1]
        Output: 2
     */

    private static int findMaxConsecutiveOnes_I(int[] nums) {

        if (nums.length == 1 && nums[0] == 1) return 1;

        int maxLength = Integer.MIN_VALUE;
        int counter = 0;
        int val = 1;

        for (int i = 0; i < nums.length; i++) {
            if (val == nums[i]) {
                counter++;
                if (counter > maxLength)
                    maxLength = counter;
            } else {
                counter = 0;
            }
        }
        return maxLength;
    }
}
