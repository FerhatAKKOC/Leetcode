package InterviewCollection.Array;

import java.util.Arrays;

public class HeightChecker {
    public static void main(String[] args) {

//        int[] heights = {1, 1, 4, 2, 1, 3};
        int[] heights = {5, 1, 2, 3, 4};

        System.out.println("Output : " + heightChecker(heights));

    }

    /*
    Input: heights = [1,1,4,2,1,3]
    Output: 3
    Explanation:
    heights:  [1,1,4,2,1,3]
    expected: [1,1,1,2,3,4]
    Indices 2, 4, and 5 do not match.
     */
    private static int heightChecker(int[] heights) {

        if (heights == null || heights.length == 1)
            return 0;

        var sorted = heights.clone();
        Arrays.sort(sorted);

        int counter = 0;

        for (int i = 0; i < heights.length; i++) {
            if (sorted[i] != heights[i])
                counter++;
        }

        return counter;
    }
}
