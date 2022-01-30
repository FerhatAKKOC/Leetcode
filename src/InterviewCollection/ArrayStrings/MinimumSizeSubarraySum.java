package InterviewCollection.ArrayStrings;

public class MinimumSizeSubarraySum {

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3}; int target = 7;
//        int[] nums = {1, 4, 4}; int target = 4;
//        int[] nums = {1,1,1,1,1,1,1,1}; int target = 11;

        System.out.println("Output : " + minSubArrayLen(target, nums));
    }

    /*
        Input: target = 7, nums = [2,3,1,2,4,3]
        Output: 2
        Explanation: The subarray [4,3] has the minimal length under the problem constraint.
     */
    private static int minSubArrayLen(int target, int[] nums) {

        int minSize = Integer.MAX_VALUE;


        for (int i = 0; i < nums.length; i++) {

            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == target && j - i < minSize)
                    minSize = j - i + 1;
            }
        }

        return minSize != Integer.MAX_VALUE ? minSize : 0;
    }
}
