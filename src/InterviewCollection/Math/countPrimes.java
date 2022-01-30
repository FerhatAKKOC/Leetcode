package InterviewCollection.Math;

import java.util.stream.IntStream;

public class countPrimes {

    public static void main(String[] args) {
        System.out.println("Count Prime : " + countPrimes(10));
    }

    private static int countPrimes(int n) {
        return (int) IntStream.rangeClosed(0, n).filter(countPrimes::isPrime).count();
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        var result = IntStream.rangeClosed(2, n - 1).filter(value -> n % value == 0).findAny();
        return result.isPresent() ? false : true;
    }
}
