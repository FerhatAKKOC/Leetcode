package InterviewCollection.CollectionsEasy;

public class buyAndSellStock_II {

    public static void main(String[] args) {
//        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {1, 2, 3, 4, 5};
        int[] prices = {7, 6, 4, 3, 1};

        System.out.println("Output: " + maxProfit2(prices));
    }

    /*
        Input: prices = [7,1,5,3,6,4]
        Output: 7
        Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
        Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
        Total profit is 4 + 3 = 7.
     */

    // iki consecutive değeri karşılaştırıyoruz. Artış olanları topluyoruz.
    private static int maxProfit2(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    //************************************************
    private static int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2)
            return 0;

        int maxProfit = 0;
        int down = 0;

        for (int up = 0; up < prices.length - 1; up++) {

            if (down == up)
                continue;

            if (prices[down] < prices[up]) {

                while (up + 1 < prices.length && prices[up] <= prices[up + 1]) up++;

                maxProfit += (prices[up] - prices[down]);
                down = up;
            } else {
                down++;
            }
        }

        return maxProfit;
    }
}
