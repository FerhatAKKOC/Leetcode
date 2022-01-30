package InterviewCollection.QueueStack;

import java.util.*;
import java.util.stream.IntStream;

public class PerfectSquares {

    public static void main(String[] args) {

        System.out.println("Output : " + numSquares(13));

    }


    private static int numSquares(int n) {

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.offer(0);
        visited.add(0);
        int depth = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            depth++;
            while (size-- > 0) {
                int u = q.poll();
                for (int i = 1; i * i <= n; i++) {
                    int v = u + i * i;
                    if (v == n) {
                        return depth;
                    }
                    if (v > n) {
                        break;
                    }
                    if (!visited.contains(v)) {
                        q.offer(v);
                        visited.add(v);
                    }
                }
            }
        }
        return depth;
    }

    //*****************************************************************
    //*****************************************************************
    //*****************************************************************
    private static int numSquaresFerat(int n) {

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);

        int depth = 0;

        while (!queue.isEmpty()) {

            depth++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {

                var val = queue.poll();

                var substractions = IntStream.range(1, val).filter(val1 -> val1 * val1 < n).map(o -> o * o).toArray();

                for (var subst : substractions) {

                    var child = val - subst;
                    if (child == 0) return depth;

                    if (!visited.contains(child))
                        queue.offer(child);
                    visited.add(child);
                }
            }
        }

        return -1;
    }


    //********************************************************************
    //********************************************************************
    //********************************************************************

    // Recursive Solution
    private static int minSquares(int n, int sq) {

        if (n == 0) return 0;

        if (sq * sq > n)
            return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;

        for (int i = sq; i * i <= n; i++) {
            int temp = n - (i * i);
            int ans = minSquares(temp, i);
            min = Math.min(ans, min);
        }

        if (min == Integer.MAX_VALUE)
            return min;


        return min + 1;
    }

    //*******************************************************************
    //*******************************************************************
    //*******************************************************************
    public class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j * j <= i; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
            return dp[n];
        }
    }
}
