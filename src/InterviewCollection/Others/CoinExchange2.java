package InterviewCollection.Others;

import java.util.ArrayList;
import java.util.List;

public class CoinExchange2 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;

        System.out.println("Output : " + change(amount, coins));
    }

    private static int change(int amount, int[] coins) {

        if (coins.length == 1 && amount == coins[0]) return 1;
        if (coins.length == 1 && amount != coins[0]) return 0;

        List<List<Integer>> list = new ArrayList<>();
        helper(coins, amount, list, new ArrayList<>());

        return list.size();
    }

    private static void helper(int[] coins, int amount, List<List<Integer>> list, List<Integer> nums) {

        if (amount == 0) {
            list.add(nums);
            System.out.println(nums);
            return;
        } else if (amount < 0) {
            return;
        } else {
            for (int coin : coins) {
                nums.add(coin);
                helper(coins, amount - coin, list, nums);
                nums.remove(nums.size() - 1);
            }
        }
    }

}
