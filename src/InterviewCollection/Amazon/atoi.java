package InterviewCollection.Amazon;

public class atoi {

    public static void main(String[] args) {
//        String s = "4193 with words";
        String s = "words 4193 with words";
//        String s = "    0042";
        System.out.println("Output: " + myAtoi(s));
    }

    private static int myAtoi(String s) {

        if (s == null || s.length() == 0) return 0;     // empty & length=0 control

        int total = 0;
        int sign = 1;
        int i = 0;

        while (i < s.length() && s.charAt(i) == ' ')    // removing whitespace
            i++;

        if (s.charAt(i) == '-' || s.charAt(i) == '+') { // determine signature
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        while (s.charAt(i) == '0') {                    // eliminate '0'
            i++;
        }

        // convert to the actual number and make sure it's not overflow
        while (i < s.length()) {
            int digit = s.charAt(i) - '0';
            if (digit < 0 || digit > 9) break;

            // check for overflow
            if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = total * 10 + digit;
            i++; // don't forget to increment the counter
        }
        return total * sign;
    }
}