package InterviewCollection.CollectionsHard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class largestRectangleInHistogram {

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
//        int[] heights = {2, 4, 5, 6, 9, 11};
//        int[] heights = {2, 4};

        System.out.println("Output: " + maxHistogram(heights));
    }

    /*
        Largest Rectangle in Histogram
        https://www.youtube.com/watch?v=ZmnqCZp9bBs
     */
    private static int maxHistogram(int[] heights) {


        Deque<Integer> stack = new LinkedList<>();
        int area = 0;
        int areaMax = 0;
        int i;

        for (i = 0; i < heights.length; ) {

            if (stack.isEmpty() || heights[stack.peekFirst()] <= heights[i]) {
                stack.offerFirst(i);
                i++;
            } else {

                int top = stack.pollFirst();

                if (stack.isEmpty())
                    area = heights[top] * i;
                else
                    area = heights[top] * (i - stack.peekFirst() - 1);

                if (area > areaMax)
                    areaMax = area;
            }
        }

        while (!stack.isEmpty()) {

            int top = stack.pollFirst();

            if (stack.isEmpty())
                area = heights[top] * i;
            else
                area = heights[top] * (i - stack.peekFirst() - 1);

            if (area > areaMax)
                areaMax = area;
        }


        return areaMax;
    }

    //**********************************************************
    // Brute Force Solution
    private static int largestRectangleArea(int[] heights) {

        int globalMax = Integer.MIN_VALUE;

        int left = 0;
        int right = 0;

        for (int i = 0; i < heights.length; i++) {

            int localMax = heights[i];
            left = i - 1;
            right = i + 1;

            while (0 <= left && heights[left] >= heights[i]) {
                localMax += heights[i];
                left--;
            }

            while (right < heights.length && heights[right] >= heights[i]) {
                localMax += heights[i];
                right++;
            }

            if (localMax > globalMax)
                globalMax = localMax;
        }

        return globalMax;
    }
}
