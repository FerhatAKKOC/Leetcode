package InterviewCollection.Strings;

import java.util.*;

public class ReverseInteger {

    public static void main(String[] args) {
        int x = 123; //  Output: 321
//        int x = -123; //  Output: -321
//        int x = 120; //  Output: 21
//         int x = 0; //  Output: 0


        System.out.println("Original: " + x);
        System.out.println("Result : " + reverse2(x));
    }

    // Write some safety lines. check x value.
    // Separete digits and push them into a collection
    // Reverse this collection
    // Evulate result according to MAX_VALUE and MIN_VALUE
    // take care of '-' sign

    // Using StringBuilder. int to String Conversion -> String reversion -> String to Int conversion

    static int reverse(int x) {

        if (x == 0) return 0;

        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = -x;
        }

        // separate digits
        List<Integer> list = new ArrayList<>();

        do {
            list.add(x % 10);
            x /= 10;
        } while (x != 0);

        list.forEach(a -> System.out.print(a));
        System.out.println();



        int size = list.size() - 1;
        long total = 0;
        for (int i = 0; i < list.size(); i++) {
            total += list.get(i) * Math.pow(10, size--);
        }

        if (isNegative) {
            total = -total;
        }

        total = (total < Integer.MIN_VALUE) ? 0 : total;
        total = (total > Integer.MAX_VALUE) ? 0 : total;

        System.out.println("Total: " + total);

        return (int) total;
    }

    static int reverse2(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }


        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int) res;
        }
    }

    static int reverse3(int x) {
        String reversed = new StringBuilder().append(Math.abs(x)).reverse().toString();
        try {
            return (x < 0) ? Integer.parseInt(reversed) * -1 : Integer.parseInt(reversed);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public int reverse4(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
