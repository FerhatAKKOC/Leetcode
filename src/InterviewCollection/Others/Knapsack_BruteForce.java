package InterviewCollection.Others;

public class Knapsack_BruteForce {

    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int Capacity = 50;
        int n = val.length;
        System.out.println(knapSack(Capacity, wt, val, n));


    }

    private static int knapSack(int Capacity, int[] wt, int[] val, int n) {

        if (n == 0 || Capacity == 0) return 0;  // Ağırlık sınırımız, yada item sınırımız dolmuş ise

        if (wt[n-1] > Capacity)
            return knapSack(Capacity, wt, val, n - 1);

        // (1) nth item included
        // (2) not included
        int max =Math.max(val[n - 1] + knapSack(Capacity - wt[n - 1], wt, val, n - 1), knapSack(Capacity, wt, val, n - 1));

        return max;
    }

}
