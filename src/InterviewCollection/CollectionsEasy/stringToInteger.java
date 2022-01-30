package InterviewCollection.CollectionsEasy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class stringToInteger {

    public static void main(String[] args) {

//        String s = "42";
//        String s = "    -42";
//       String s = "    -4193 with words";
//       String s = " words and 987";
        String s = "-91283472332";

        System.out.println(s);
        myAtoi(s);


//        System.out.println("Output: " + myAtoi(s));
    }

    private static int myAtoi(String s) {

        if (s == null || s.length() == 0)
            return 0;

        List<Character> numbers = new ArrayList<>();
        int sign = 0;

        for (char a : s.toCharArray()) {

            if (Character.isWhitespace(a))   // whiteSpace
                continue;

            if (a == '-' || a == '+') {         // '-'  '+'
                sign = a == '-' ? -1 : +1;
                continue;
            }

            if (Character.isLetter(a))
                break;

            if (Character.isDigit(a)) {
                numbers.add(a);
            }
        }

        if (numbers.size() == 0) { // not found any digit character
            return 0;
        } else {

            StringBuilder stringBuilder = new StringBuilder();
            for (var a : numbers) {
                stringBuilder.append(a);
            }

            var bigInteger = new BigInteger(stringBuilder.toString());

            Integer nums = 0;
            if (bigInteger.longValue() < Integer.MIN_VALUE) {
                nums = Integer.MIN_VALUE;
            } else if (bigInteger.longValue() > Integer.MAX_VALUE) {
                nums = Integer.MIN_VALUE;
            } else {
                nums = Integer.valueOf(stringBuilder.toString());
            }
            return sign == -1 ? -nums : nums;
        }
    }
}
