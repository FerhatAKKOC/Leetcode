package InterviewCollection.Recursions;

import java.util.HashMap;

public class climbStairs {

    public static void main(String[] args) {

        System.out.println("Output: " + climbStairs(6));
    }


    private static HashMap<Integer, Integer> cache = new HashMap();

    private static int climbStairs(int n) {

        if (cache.containsKey(n))
            return cache.get(n);

        if (n < 3) return n;  // base

        int result = climbStairs(n - 1) + climbStairs(n - 2);

        cache.put(n, result);

        return result;


    }
}
