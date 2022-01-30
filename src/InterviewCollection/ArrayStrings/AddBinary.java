package InterviewCollection.ArrayStrings;

public class AddBinary {

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";


        System.out.println("Output : " + addBinary(a, b));
    }

    /*
        Input: a = "1010", b = "1011"
        Output: "10101"
     */
    private static String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 && j >= 0) {

            int sum = carry;

            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';

            sb.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
    /*
        int a1 = '0';
        int b1 = '1';
        System.out.println("0: " + a1);
        System.out.println("1: " + b1);
        System.out.println("1-0: " + (b1-a1));
     */
}
