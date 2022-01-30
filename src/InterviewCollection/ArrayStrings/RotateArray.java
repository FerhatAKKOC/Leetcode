package InterviewCollection.ArrayStrings;

public class RotateArray {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);

        for (var a : nums)
            System.out.print(a + " ");
    }

    /*
        Input: nums = [1,2,3,4,5,6,7], k = 3
        Output: [5,6,7,1,2,3,4]
     */
    private static void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            rotateHelper(nums);
        }
    }

    private static void rotateHelper(int[] nums) {

        for (int i = nums.length - 1; 0 < i; i--) {
            int temp = nums[i];
            nums[i] = nums[i - 1];
            nums[i - 1] = temp;
        }
    }
}
