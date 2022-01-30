package InterviewCollection.Array;

public class ThirdMaximumNumber {

    public static void main(String[] args) {

//        int[] nums = {2, 2, 3, 1};
//        int[] nums = {3,2,1};
        int[] nums = {1, 2};

        System.out.println(thirdMax(nums));
    }

    private static int thirdMax(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        if (nums.length == 2) {
            third = Math.min(nums[0], nums[1]);
        }

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > first)
                first = nums[i];
            else if (nums[i] > second)
                second = nums[i];
            else if (nums[i] > third)
                third = nums[i];
        }

        return third;
    }
}
