package InterviewCollection.Array;

public class EvenNumberofDigits {

    public static void main(String[] args) {

//        int[] nums = {12, 345, 2, 6, 7896};
        int[] nums = {555,901,482,1771};

        System.out.println("Output : " + findNumbers(nums));

//        System.out.println(digitNumber(1));
    }


    /*
        Given an array nums of integers, return how many of them contain an even number of digits.

        Input: nums = [12,345,2,6,7896]
        Output: 2
        Explanation:
        12 contains 2 digits (even number of digits).
        345 contains 3 digits (odd number of digits).
        2 contains 1 digit (odd number of digits).
        6 contains 1 digit (odd number of digits).
        7896 contains 4 digits (even number of digits).
        Therefore only 12 and 7896 contain an even number of digits.
     */
    private static int findNumbers(int[] nums) {

        int evenNumOfDigit = 0;

        for (var num : nums) {
            if (digitNumber(num) % 2 == 0) {
                evenNumOfDigit++;
            }
        }

        return evenNumOfDigit;
    }

    private static int digitNumber(int num) {

        int digitNum = 0;

        while (num > 0) {
            num /= 10;
            digitNum++;
        }
        return digitNum;
    }


}
