package InterviewCollection.BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {

        int[] nums1 = {2};
        int[] nums2 = {};

        System.out.println("Median : " + findMedianSortedArrays(nums1, nums2));

    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        var mergeList = merge(nums1, nums2);

        int n = mergeList.length;

        if (mergeList.length % 2 == 1) {
            return mergeList[mergeList.length / 2];
        } else {
            return (mergeList[n/2 - 1] + mergeList[n/2]) / (double) 2;
        }
    }

    private static int[] merge(int[] nums1, int[] nums2) {

        int ptr1 = 0;
        int ptr2 = 0;

        List<Integer> mergeList = new ArrayList<>();

        while (ptr1 < nums1.length && ptr2 < nums2.length) {

            if (nums1[ptr1] < nums2[ptr2]) {
                mergeList.add(nums1[ptr1++]);
            } else {
                mergeList.add(nums2[ptr2++]);
            }
        }

        while (ptr1 < nums1.length) {
            mergeList.add(nums1[ptr1++]);
        }

        while (ptr2 < nums2.length) {
            mergeList.add(nums2[ptr2++]);
        }

        return mergeList.stream().mapToInt(i -> i).toArray();
    }
}
