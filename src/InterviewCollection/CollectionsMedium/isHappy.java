package InterviewCollection.CollectionsMedium;

import java.util.HashSet;
import java.util.Set;

public class isHappy {

    public static void main(String[] args) {

        System.out.println("Output: " + isHappy(19));

    }


    private static boolean isHappy(int n) {

        if (n == 1) return true;
        if (n == 2) return false;

        Set<Integer> set = new HashSet<>();
        set.add(n);

        while (n > 1) {
            n = digitSum(n);
            if (set.contains(n))
                return false;
            set.add(n);
        }

        return true;
    }

    private static int digitSum(int n) {

        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}

