package InterviewCollection.Amazon;

public class containerWithMostWater {

    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println("Output: " + maxArea(height));
    }

    /* Container With Most Water */
    private static int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int maxArea = Integer.MIN_VALUE;

        while (left < right) {
            int local = 0;

            if (height[left] <= height[right] ) {
                local = height[left] * (right - left);
                left++;
            } else {
                local = height[right] * (right - left);
                right--;
            }

            if (local > maxArea)
                maxArea = local;
        }

        return maxArea;
    }
}
