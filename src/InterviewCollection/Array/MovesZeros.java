package InterviewCollection.Array;

import java.util.Arrays;

public class MovesZeros {

    /*
        Input: nums = [0,1,0,3,12]  , Moves zeros to the end of array
        Output: [1,3,12,0,0]
     */
    public static void main(String[] args) {


        var nums = Arrays.asList(0,1,0,3,12).stream().mapToInt(v -> v).toArray();
        moveZeroes(nums);
        for(var elem : nums)
            System.out.print(elem + " ");

    }

    // firstly sorts array and shifts rigth
    // Using two nested for loops. refactor or optimize the get higher performance and efficency
    // Two pointer approach
//        [0,1,0,3,12]
//        [1,0,0,3,12]
//        [1,3,0,0,12]

    static void moveZeroes(int[] nums) {

        int start = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[start] == 0 && nums[i] != 0) {
                nums[start] = nums[i];
                nums[i] = 0;
                start++;
            }
        }
    }
}
