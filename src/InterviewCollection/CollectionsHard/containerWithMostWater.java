package InterviewCollection.CollectionsHard;

public class containerWithMostWater {

    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println("Output: " + maxArea(height));
    }

    /*
    Container With Most Water
    https://www.youtube.com/watch?v=UuiTKBwPgAo
     */
    private static int maxArea(int[] height) {

        int n = height.length;
        int left = 0;
        int right = n - 1;

        int max = Integer.MIN_VALUE;

        while (left < right) {

            int min = Math.min(height[left], height[right]);
            int local = min * (right - left);

            if (local > max)
                max = local;

            if (height[left] > height[right])
                right--;
            else
                left++;
        }

        return max;
    }
}
