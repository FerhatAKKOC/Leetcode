package InterviewCollection.CollectionsMedium;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class findPeakElement {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3, 1, 2, 3, 5, 3};

        System.out.println("Output: " + findPeakElement(nums));

    }

    /*
        Note: Soruda maximum elemanı istemiyor, Herhangi bir local peak elemanı istiyor.
     */
    private static int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int middle = (left + right) / 2;

            // Belki burada middle elementin sağı ve solu kontrol edilerek direk bir cevap dönülebilinir.

            if (nums[middle] > nums[middle + 1]) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }
}
