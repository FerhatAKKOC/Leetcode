package InterviewCollection.Recursions;

import java.util.Arrays;

public class sortArray_Recursively {

    public static void main(String[] args) {
        int[] input = {5, 1, 1, 2, 0, 0};
        Arrays.stream(input).forEach(System.out::print);
        var output = sortArray(input);

        System.out.println();
        Arrays.stream(output).forEach(System.out::print);
    }

    /*
         Top -> Down
     */
    private static int[] sortArray(int[] nums) {

        if (nums.length <= 1)
            return nums;

        int pivot = nums.length / 2;

        var left = sortArray(Arrays.copyOfRange(nums, 0, pivot));
        var right = sortArray(Arrays.copyOfRange(nums, pivot, nums.length));
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {

        int[] ret = new int[left.length + right.length];

        int leftCnt = 0, rightCnt = 0, curCnt = 0;

        while (leftCnt < left.length && rightCnt < right.length) {

            if (left[leftCnt] < right[rightCnt])
                ret[curCnt++] = left[leftCnt++];
            else
                ret[curCnt++] = right[rightCnt++];
        }

        while (leftCnt < left.length) {
            ret[curCnt++] = left[leftCnt++];
        }

        while (rightCnt < right.length) {
            ret[curCnt++] = right[rightCnt++];
        }

        return ret;
    }
}
