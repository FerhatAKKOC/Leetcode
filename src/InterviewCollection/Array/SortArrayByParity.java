package InterviewCollection.Array;

public class SortArrayByParity {

    public static void main(String[] args) {

        int[] nums = {3, 1, 2, 4};
        sortArrayByParity(nums);
        for (var a : nums)
            System.out.print(a + " ");

    }

    /*
        Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

        Input: nums = [3,1,2,4]
        Output: [2,4,3,1]
     */
    private static int[] sortArrayByParity(int[] nums) {

        if (nums.length == 1)
            return nums;

        int start = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[start] % 2 == 0) {
                start++;
            } else if (nums[i] % 2 == 0) {
                int temp = nums[start];
                nums[start] = nums[i];
                nums[i] = temp;
                start++;
            }
        }

        return nums;
    }
}
