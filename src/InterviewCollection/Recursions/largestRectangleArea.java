package InterviewCollection.Recursions;

public class largestRectangleArea {

    public static void main(String[] args) {


        int[] heights = {2, 1, 5, 6, 2, 3};

        System.out.println("Output: " + largestRectangleArea(heights));
    }

    private static int largestRectangleArea(int[] heights) {

        if (heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];
        if (heights.length == 2) return 2 * Integer.min(heights[0], heights[1]);

        int N = heights.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {

            int sum = heights[i];

            // left side blocks  checking
            for (int left = i - 1; 0 <= left; left--) {
                if (heights[left] >= heights[i])
                    sum += heights[i];
                else
                    break;
            }

            // Right side blocks checking
            for (int right = i + 1; right < N; right++) {
                if (heights[right] >= heights[i])
                    sum += heights[i];
                else
                    break;
            }

            if (sum > maxSum)
                maxSum = sum;
        }

        return maxSum;
    }

}
