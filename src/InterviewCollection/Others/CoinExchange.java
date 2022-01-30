package InterviewCollection.Others;

import java.util.LinkedList;
import java.util.Queue;

public class CoinExchange {

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        int amount = 11;

        System.out.println("Output : " + coinChange(coins, amount));


    }

    /*
        You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
        Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
        You may assume that you have an infinite number of each kind of coin.
     */
    private static int coinChange(int[] coins, int amount) {

        if (amount < 1) return 0;
        if (coins.length == 1 && amount % coins[0] == 0) return amount / coins[0];

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[amount + 1];

        queue.offer(amount);
        visited[amount] = true;

        int currLevel = 0;

        while (!queue.isEmpty()) {

            currLevel++;

            int size = queue.size();
            System.out.println(queue);

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                for (int coin : coins) {
                    int child = curr - coin;
                    if (child == 0) {
                        return currLevel;
                    } else if (child > 0 && !visited[child]) {
                        queue.add(child);
                        visited[child] = true;
                    }
                }
            }
        }
        return -1;
    }
}
