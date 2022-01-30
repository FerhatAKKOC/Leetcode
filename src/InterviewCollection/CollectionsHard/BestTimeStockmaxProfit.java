package InterviewCollection.CollectionsHard;

public class BestTimeStockmaxProfit {

    public static void main(String[] args) {

        int[] prices = {1, 2, 3, 0, 2};

        System.out.println("Output: " + maxProfit(prices));
    }

    /*
        Best Time to Buy and Sell Stock with Cooldown
        https://www.youtube.com/watch?v=4wNXkhAky3s
     */
    private static int maxProfit(int[] prices) {

        if (prices == null || prices.length == 1)
            return 0;

        int prevCooldown = 0;
        int prevSold = 0;
        int prevInHand = 0;

        int currCooldown = 0;
        int currSold = 0;
        int currInHand = -prices[0];


        for (int i = 1; i < prices.length; i++) {  // 1'den başla

            currCooldown = Math.max(prevCooldown, prevSold);
            currInHand = Math.max(prevInHand, (prevCooldown - prices[i]));
            currSold = prevInHand + prices[i];


            prevCooldown = currCooldown;
            prevInHand = currInHand;
            prevSold = currSold;
        }


        return Math.max(currCooldown, currCooldown);
    }
}
