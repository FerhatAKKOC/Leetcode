package InterviewCollection.Amazon;

public class maxProfit {

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println("Output:" + maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {

        int maxProfit = Integer.MIN_VALUE;
        int minValue = prices[0];

        for (var val : prices) {

            if (val < minValue)
                minValue = val;

            if ((val - minValue) > maxProfit)
                maxProfit = (val - minValue);
        }

        return maxProfit > 0 ? maxProfit : 0;
    }
}
