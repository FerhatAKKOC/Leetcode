package InterviewCollection.DynamicProgramming;

public class robber {

    public static void main(String[] args) {

        int nums[] = {6, 7, 1, 3, 8, 2, 4};
        System.out.println("Maximum loot value : " + rob(nums));

    }
/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and
it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Yeni bir dp array oluşturulur. Soldan sağa bu array her zaman maximum çalınabilecek para miktarını tutar.
 */
    private static int rob(int[] nums) {

        int n = nums.length;

        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        // dp[i] represent the maximum value stolen
        // so far after reaching house i.
        int[] dp = new int[n];

        // Initialize the dp[0] and dp[1]
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // Fill remaining positions
        for (int i = 2; i < n; i++)
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);

        return dp[n - 1];
    }
}
