package InterviewCollection.HashTable;

import java.util.*;

public class isHappy {

    public static void main(String[] args) {

        System.out.println("Output : " + isHappy2(2));

    }

    /*
The idea is to use one hash set to record sum of every digit square of every number occurred.
Once the current sum cannot be added to set, return false; once the current sum equals 1, return true;
 */
    private static boolean isHappy2(int n) {

        Set<Integer> set = new HashSet<>();

        while (true) {

            set.add(n);
            n = sumDigits(n);
            if (n == 1) return true;
            if (set.contains(n)) return false;
        }
    }

    private static int sumDigits(int n) {

        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }

        return sum;
    }

    //*********************************************************************************
    //*********************************************************************************
    //*********************************************************************************

    private static boolean isHappy(int n) {

        if (n == 1) return true;

        int total = 0;
        for (var val : digits(n))
            total += val * val;
        System.out.println("Total: " + total);
        return isHappy(total);
    }

    private static List<Integer> digits(int n) {

        List<Integer> list = new ArrayList<>();

        while (n > 0) {
            list.add(n % 10);
            n = n / 10;
        }
        System.out.println(list);
        return list;
    }


}
