package InterviewCollection.CollectionsEasy;

public class rotateArray {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotate(nums, k);

        for (var a : nums)
            System.out.print(a + " ");
    }

    private static void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k == 0) return;
        for (int i = 0; i < k; i++) {
            shiftOne(nums);
        }
    }

    private static void shiftOne(int[] nums) {
        for (int i = nums.length - 1; 0 < i; i--) {
            int temp = nums[i - 1];
            nums[i - 1] = nums[i];
            nums[i] = temp;
        }
    }
}
