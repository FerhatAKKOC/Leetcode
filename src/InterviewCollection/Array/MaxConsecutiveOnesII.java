package InterviewCollection.Array;

import javax.swing.table.TableRowSorter;

public class MaxConsecutiveOnesII {

    public static void main(String[] args) {

//        int[] arr = {1, 0, 1, 1, 0};
        int[] arr = {1, 1, 0, 0, 1, 1, 1, 1, 1};

        System.out.println("Output : " + findMaxConsecutiveOnes_II(arr));
    }

    /*
        Input: [1,0,1,1,0]
        Output: 4
        Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
        After flipping, the maximum number of consecutive 1s is 4.
     */
    private static int findMaxConsecutiveOnes_II(int[] nums) {


        int maxCounter = Integer.MIN_VALUE;
        int counter = 0;
        int val = 1;
        boolean zero = true;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1 || zero) {

                counter++;
                if (counter > maxCounter)
                    maxCounter = counter;

                if (nums[i] == 0)
                    zero = false;

            } else {
                counter = 0;
                zero = true;
                i--;
            }
        }
        return maxCounter;
    }
}
