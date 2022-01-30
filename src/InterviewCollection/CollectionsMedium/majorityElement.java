package InterviewCollection.CollectionsMedium;

import java.util.Arrays;

public class majorityElement {

    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        System.out.println("Output: " + majorityElement(nums));


    }

    private static int majorityElement(int[] nums) {

        int n = nums.length;

        Arrays.sort(nums);

        int max = Integer.MIN_VALUE;
        int maxkey = 0;
        int key = nums[0];
        int count = 0;

        for (var num : nums) {

            if (key == num) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                    maxkey = key;
                }
                count = 1;
                key = num;
            }
        }
        if (count > max) {
            maxkey = key;
        }

        return maxkey;
    }
}
