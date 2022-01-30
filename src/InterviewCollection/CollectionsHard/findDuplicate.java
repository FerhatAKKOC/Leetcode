package InterviewCollection.CollectionsHard;

public class findDuplicate {

    public static void main(String[] args) {
//        int[] nums = {1, 3, 4, 2, 2};
//        int[] nums = {3, 1, 3, 4, 2};
//        int[] nums = {1,1,2};
        int[] nums = {1,2,2};
//        int[] nums = {1,1};

        System.out.println("Output: " + findDuplicate(nums));
    }

    /*Find the Duplicate Number*/
    private static int findDuplicate(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0)
                return index + 1;
            else
                nums[index] *= -1;
        }

        return n;
    }
}
