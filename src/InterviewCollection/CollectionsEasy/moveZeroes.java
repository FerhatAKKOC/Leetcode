package InterviewCollection.CollectionsEasy;

public class moveZeroes {

    public static void main(String[] args) {
//        int[] nums = {0, 1, 0, 3, 12};
        int[] nums = {0};
        moveZeroes(nums);

        for (var num : nums)
            System.out.print(num + " ");
    }

    /*
        Input: nums = [0,1,0,3,12]
        Output: [1,3,12,0,0]
     */
    private static void moveZeroes(int[] nums) {

        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {

            if (nums[slow] != 0) {
                slow++;
                continue;
            }

            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                nums[fast] = 0;
                slow++;
            }
        }
    }
}
