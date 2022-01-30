package InterviewCollection.CollectionsHard;

public class burstBalloons {

    public static void main(String[] args) {

    }

    /*
        Burst Balloons
        https://www.youtube.com/watch?v=uG_MtaCJIrM

     */
    private static int maxCoins(int[] iNums) {

        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums)
            if (x > 0) nums[n++] = x;  // '0' numaraları balonları atıyoruz. etki etmiyorlarç

        nums[0] = nums[n++] = 1;

        int[][] dp = new int[n][n];  // '0' balonlar atıldıktan sonra kalanlarla devam ediyoruz.

        for (int win = 2; win < n; ++win)

            for (int left = 0; left < n - win; ++left) {

                int right = left + win;

                for (int i = left + 1; i < right; ++i)

                    dp[left][right] = Math.max(dp[left][right], nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
            }

        return dp[0][n - 1];
    }
}


































