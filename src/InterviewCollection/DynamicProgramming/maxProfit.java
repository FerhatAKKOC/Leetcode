package InterviewCollection.DynamicProgramming;

import java.util.Arrays;

public class maxProfit {

    public static void main(String[] args) {

//        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int[] prices = new int[]{7,6,4,3,1};

        System.out.println("Max Profit : " + maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {

        int maxProfit = 0;
        int minValue = Arrays.stream(prices).max().getAsInt();


        for (int i = 0; i <prices.length ; i++) {

            if(minValue > prices[i]){
                minValue = prices[i];
            }

            if((prices[i] - minValue) > maxProfit){
                maxProfit = (prices[i] - minValue);
            }

        }

        return maxProfit;
    }

}
