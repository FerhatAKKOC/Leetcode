package InterviewCollection.Array;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

public class RemoveElement {

    public static void main(String[] args) {
//        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2}; int val = 2;

        int[] nums = {3, 2, 2, 3};
        int val = 2;

        var output = removeElement(nums, val);

        System.out.println("Output : " + output);
        for (var a : nums) {
            System.out.print(a + " ");
        }
    }

    /*
    Input: nums = [3,2,2,3], val = 3
    Output: 2, nums = [2,2,_,_]
    Explanation: Your function should return k = 2, with the first two elements of nums being 2.
    It does not matter what you leave beyond the returned k (hence they are underscores).

    Input: nums = [0,1,2,2,3,0,4,2], val = 2
    Output: 5, nums = [0,1,4,0,3,_,_,_]

     */
    private static int removeElement(int[] nums, int val) {

        int counter = 0;
        int end = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == val && i < end) {

                if (nums[end] != val) {
                    swap(nums, i, end);
                    counter++;
                } else {
                    end--;
                    i--;
                }
            }
        }
        return nums.length - 1 - counter;
    }

    private static void swap(int[] nums, int i, int end) {
        int temp = nums[i];
        nums[i] = nums[end];
        nums[end] = temp;
    }

    //**************************************************************
    //**************************************************************
    //**************************************************************
    private static int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
