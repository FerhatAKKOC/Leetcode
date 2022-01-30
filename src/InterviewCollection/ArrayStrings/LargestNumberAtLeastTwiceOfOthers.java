package InterviewCollection.ArrayStrings;

public class LargestNumberAtLeastTwiceOfOthers {

    public static void main(String[] args) {

        int[] nums = {3, 6, 1, 0};
//        int[] nums = {1, 2, 3, 4};
//        int[] nums = {1};


        System.out.println("Output : " + dominantIndex(nums));
    }

    /*
        You are given an integer array nums where the largest integer is unique.
        Input: nums = [3,6,1,0] Output: 1
        Explanation: 6 is the largest integer.
        For every other number in the array x, 6 is at least twice as big as x.
        The index of value 6 is 1, so we return 1.
     */
    private static int dominantIndex(int[] nums) {

        int max = -1, index = -1, second = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                second = max;
                max = nums[i];
                index = i;
            } else if (nums[i] > second)
                second = nums[i];
        }

        return second * 2 <= max ? index : -1;
    }
}
