package InterviewCollection.Recursions;

import java.util.HashMap;

public class Fibonacci {

    public static void main(String[] args) {

        System.out.println("Output: " + fib(3));
    }

    static HashMap<Integer, Integer> cache = new HashMap<>();

    // 0, 1, 1, 2, 3, 5, 8, 11, 19,
    //F(0) = 0, F(1) = 1
    private static int fib(int n) {

        if (cache.containsKey(n))
            return cache.get(n);

        if (n == 0) return 0;
        if (n == 1) return 1;

        int result = fib(n - 2) + fib(n - 1);

        cache.put(n, result);

        return result;


    }
}
