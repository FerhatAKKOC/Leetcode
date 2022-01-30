package InterviewCollection.ArrayStrings;

public class FindPivotIndex {

    public static void main(String[] args) {

//        int[] nums = {1, 7, 3, 6, 5, 6};
//        int[] nums = {2,1,-1};
        int[] nums = {1, 2, 3};


        System.out.println("Output : " + pivotIndex(nums));

    }

    /*
        Given an array of integers nums, calculate the pivot index of this array.
        Input: nums = [1,7,3,6,5,6]
        The pivot index is 3.
        Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
        Right sum = nums[4] + nums[5] = 5 + 6 = 11
     */
    private static int pivotIndex(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            // left side
            int left = 0;
            for (int j = 0; j < i; j++) {
                left += nums[j];
            }

            int right = 0;
            for (int j = i + 1; j < nums.length; j++) {
                right += nums[j];
            }

            if (left == right)
                return i;
        }

        return -1;
    }

    //*****************************************************************
    //*****************************************************************
    public int pivotIndex2(int[] nums) {

        int sum = 0, leftsum = 0;

        for (int x : nums) sum += x;

        for (int i = 0; i < nums.length; ++i) {
            int rightsum = sum - leftsum - nums[i];
            if (leftsum == rightsum)
                return i;
            leftsum += nums[i];
        }
        return -1;
    }
}

