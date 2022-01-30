package InterviewCollection.CollectionsMedium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class fractionToDecimal {

    public static void main(String[] args) {
//        System.out.println("Output: " + fractionToDecimal(1, 5));
//        System.out.println("Output: " + fractionToDecimal(2, 3));
        System.out.println("Output: " + fractionToDecimal(4, 333));
    }

    // Fraction to Recurring Decimal
    private static String fractionToDecimal(int numerator, int denominator) {

        StringBuilder result = new StringBuilder();

        String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        result.append(sign);
        result.append(num / den);

        long remainder = num % den;

        if (remainder == 0)
            return result.toString();

        result.append(".");

        Set<Long> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        System.out.println("reminder : " + remainder);

        while (remainder != 0) {
            remainder *= 10;
            if (!set.contains(remainder)) {  // tekrar aynı rakam gelirse, artık o noktadan sonra tekrarlamalar başladığı için sonlandırıyoruz.
                set.add(remainder);
                sb.append(remainder / den);
            } else {
                return result.append("(" + sb.toString() + ")").toString();
            }
            System.out.println(remainder + "  =>   " + sb.toString());
            remainder %= den;
        }

        return result.append(sb.toString()).toString();

//        Map<Long, Integer> map = new HashMap(); //store numerator as repetition of same numerator will cause recurring
//
//        while (remainder != 0) {
//            if (!map.containsKey(remainder)) {
//                map.put(remainder, result.length()); //for a given numerator its (num*10)/den starts from this idx
//            } else {
//                int idx = map.get(remainder);
//                return result.substring(0, idx) + "(" + result.substring(idx) + ")";
//            }
//            remainder *= 10;
//            result.append(remainder / den);
//            remainder = remainder % den;
//        }
//        return result.toString();

    }
}


//***************************************************************************
//**********       https://www.youtube.com/watch?v=zNe2qXCDPIM    ***********
//***************************************************************************