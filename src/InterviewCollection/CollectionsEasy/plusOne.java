package InterviewCollection.CollectionsEasy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class plusOne {

    public static void main(String[] args) {
//        int[] digits = {4, 3, 2, 1};
//        int[] digits = {0};
        int[] digits = {9};

        var output = plusOne(digits);

        for (var o : output)
            System.out.print(o + " ");
    }

    /*
        Input: digits = [4,3,2,1]
        Output: [4,3,2,2]
        Explanation: The array represents the integer 4321.
        Incrementing by one gives 4321 + 1 = 4322.
        Thus, the result should be [4,3,2,2].
     */
    private static int[] plusOne(int[] digits) {

        List<Integer> list = new ArrayList<>();
        int residual = 1;
        for (int i = digits.length - 1; 0 <= i; i--) {

            int sum = digits[i] + residual;
            list.add(sum % 10);
            residual = sum / 10;
        }

        if (residual > 0)
            list.add(residual);

        Collections.reverse(list);
        return list.stream().mapToInt(i -> i).toArray();
    }
}
