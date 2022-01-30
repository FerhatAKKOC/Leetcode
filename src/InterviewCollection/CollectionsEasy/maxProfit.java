package InterviewCollection.CollectionsEasy;

public class maxProfit {

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println("Output: " + maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {

        int minValue = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;


        for (var price : prices) {
            if (price < minValue)
                minValue = price;

            if ((price - minValue) > maxProfit)
                maxProfit = (price - minValue);
        }
        return maxProfit;
    }

}
