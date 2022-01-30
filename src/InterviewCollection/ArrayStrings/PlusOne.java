package InterviewCollection.ArrayStrings;

public class PlusOne {
    public static void main(String[] args) {

//        int[] digits = {1, 2, 3};
//        int[] digits = {4, 3, 2, 1};
        int[] digits = {0};
        var output = plusOne(digits);

        for (var digit : output)
            System.out.print(digit + " ");
    }

    /*
        Input: digits = [1,2,3]
        Output: [1,2,4]
        Explanation: The array represents the integer 123.
     */

    private static int[] plusOne(int[] digits) {

        int[] arr = new int[digits.length];
        int remaining = 1;

        for (int i = digits.length - 1; 0 <= i; i--) {

            arr[i] = (digits[i] + remaining) % 10;
            remaining = (digits[i] + remaining) / 10;
        }
        return arr;
    }
}
