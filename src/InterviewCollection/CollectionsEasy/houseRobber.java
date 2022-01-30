package InterviewCollection.CollectionsEasy;

public class houseRobber {

    public static void main(String[] args) {

//        int[] nums = {6, 7, 1, 3, 8, 2, 4};
        int[] nums = {2, 7, 9, 3, 1};

        System.out.println("Output: " + rob(nums));
    }

    // House robber
    private static int rob(int[] nums) {

        int n = nums.length;

        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);


        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = nums[1];

        // Soldan sağa doğru her zaman maximum toplamı elde edecek sekilde dp'yi dolduruyoruz.

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[n - 1];
    }
}
