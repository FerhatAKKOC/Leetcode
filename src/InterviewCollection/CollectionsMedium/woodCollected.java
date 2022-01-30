package InterviewCollection.CollectionsMedium;

import java.util.Arrays;

public class woodCollected {

    public static void main(String[] args) {
        int[] height = new int[]{1, 2, 1, 2};
        int k = 2;
        System.out.print("Output: " + collectKWood(height, k));
    }

    /*
        Value to be subtracted from array elements to make sum of all elements equals K
        https://www.geeksforgeeks.org/value-to-be-subtracted-from-array-elements-to-make-sum-of-all-elements-equals-k/
     */
    public static int collectKWood(int[] height, int k) {

        int n = height.length;

        Arrays.sort(height);

        // The minimum and the maximum cut that can be made
        int low = 0, high = height[n - 1];

        // Binary search to find the answer
        while (low <= high) {
            int mid = low + ((high - low) / 2);

            // The amount of wood collected when cut is made at the mid
            int collected = woodCollected(height, mid);

            // If the current collected wood is equal to the required amount
            if (collected == k)
                return mid;

            // If it is more than the required amount then the cut needs to be made at a height higher than the current height
            if (collected > k)
                low = mid + 1;
                // Else made the cut at a lower height
            else
                high = mid - 1;
        }
        return -1;

    }

    public static int woodCollected(int[] height, int m) {

        int sum = 0;

        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] - m <= 0)
                break;
            sum += (height[i] - m);
        }
        return sum;
    }

}
