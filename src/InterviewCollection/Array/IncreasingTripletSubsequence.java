package InterviewCollection.Array;

public class IncreasingTripletSubsequence {

    public static void main(String[] args) {
//        int[] nums = {2, 1, 5, 0, 4, 6};
//        int[] nums = {1, 2, 3, 4, 5};
        int[] nums = {5, 4, 3, 2, 1};

        System.out.println("Output : " + increasingTriplet(nums));
    }

    /*
        Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k].
         If no such indices exists, return false.
        Input: nums = [2,1,5,0,4,6]
        Output: true
        Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.

        Small   Big
        M       M
        2       M
        1       M
        1       5
        0       5
        0       4
        0       4       6   (Solution)
    */
    private static boolean increasingTriplet(int[] nums) {
        // start with two largest values, as soon as we find a number bigger than both, while both have been updated, return true.
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n <= small) { small = n; } // update small if n is smaller than both
            else if (n <= big) { big = n; } // update big only if greater than small but smaller than big
            else return true; // return if you find a number bigger than both
        }
        return false;
    }
}
