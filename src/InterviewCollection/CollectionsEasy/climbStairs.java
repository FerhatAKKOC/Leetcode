package InterviewCollection.CollectionsEasy;

public class climbStairs {

    public static void main(String[] args) {

        System.out.println("Output: " + climbStairs(5));
    }

    /*
        You are climbing a staircase. It takes n steps to reach the top.
        Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     */
    private static int climbStairs(int n) {
        //Base Cases
        if (n < 3) return n;
        return climbStairs(n-2)+climbStairs(n-1);
    }
}
