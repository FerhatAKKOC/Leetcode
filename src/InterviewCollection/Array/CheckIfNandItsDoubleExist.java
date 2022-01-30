package InterviewCollection.Array;

import java.util.HashSet;
import java.util.Set;

public class CheckIfNandItsDoubleExist {

    public static void main(String[] args) {

//        int[] arr = {10, 2, 5, 3};
//        int[] arr = {7, 1, 14, 11};
        int[] arr = {3, 1, 7, 11};

        System.out.println("Output : " + checkIfExist(arr));

    }

    /*

    Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).

    Input: arr = [10,2,5,3]
    Output: true
    Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.

    Input: arr = [7,1,14,11]
    Output: true
    Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.
     */
    private static boolean checkIfExist(int[] arr) {

        Set<Integer> set = new HashSet<>();

        for (var num : arr) {

            if (set.contains(num))
                return true;
            else {
                set.add(num * 2);
                if (num % 2 == 0)
                    set.add(num / 2);
            }

        }

        return false;
    }
}
