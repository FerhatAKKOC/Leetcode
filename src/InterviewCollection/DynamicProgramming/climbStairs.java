package InterviewCollection.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class climbStairs {

    public static void main(String[] args) {

    }

    private static int climbStairs(int n) {
        //return climb_Stairs2(0, n);
        return climbStairs3(n);
    }

    // Dynamic Programming, Bottom-up implementation
    private static int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    private static int climbStairs1(int n) {

        Map<Integer, Integer> cache = new HashMap<>();

        if (n < 2)
            return 1;

        if (cache.containsValue(n))
            return cache.get(n);

        int ans = climbStairs1(n-2) + climbStairs1(n-1);

        cache.put(n, ans);
        return ans;
    }

    // climb_Stairs2(0, n); gibi bir çağrı yapılacaktır.
    public int climb_Stairs2(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs2(i + 1, n) + climb_Stairs2(i + 2, n);
    }



}
