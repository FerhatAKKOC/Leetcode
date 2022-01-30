package InterviewCollection.Amazon;

public class reverseInteger {

    public static void main(String[] args) {

        int x = -123;
//        int x = 120;
//        int x = 0;
        System.out.println("Output: " + reverse(x));
    }

    /*
         Reverse Integer
     */
    private static int reverse(int x) {

        int sign = (x < 0) ? -1 : 1;
        x = Math.abs(x);
        int rev = 0;

        while (x > 0) {
            int pop = x % 10;

            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;  // rev⋅10+pop will overflow if and only if {pop} > 7
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;

            rev = rev * 10 + pop;

            x /= 10;
        }

        return rev*sign;
    }
    /*
        overflow
        x=Integer.MAX_VALUE  = 2147483647.  Eger x+1 yaparsak -2147483647 olur.
        01111111111111111111111111111111 +1 == 10000000000000000000000000000000

        Integer.MAX_VALUE/10  => 214748364 olur. Tekrardan buna 17 eklersek overflow olmaz. fakat 18 eklersek overflow olur. Negative sayı kısmına geçer
     */

}
