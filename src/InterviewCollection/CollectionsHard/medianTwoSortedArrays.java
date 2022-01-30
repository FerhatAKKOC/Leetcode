package InterviewCollection.CollectionsHard;

public class medianTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 8, 9, 15};
        int[] nums2 = {7, 11, 18, 19, 21, 25};

        System.out.println("Output: " + findMedianSortedArrays(nums1, nums2));

    }

    /*
        Median of Two Sorted Arrays
        https://www.youtube.com/watch?v=LPFhl65R7ww
     */
    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {


        int lenX = nums1.length;
        int lenY = nums2.length;

        if (lenX > lenY)
            findMedianSortedArrays(nums2, nums1);

        int start = 0;
        int end = lenX;

        while (start <= end) {

            int partitionX = (start + end) / 2;
            int partitionY = (lenY + lenX + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRigtX = (partitionX == lenX) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRigtY = (partitionY == lenY) ? Integer.MAX_VALUE : nums2[partitionY];


            if (maxLeftX <= minRigtY && minRigtX >= maxLeftY) {

                if ((lenX + lenY) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRigtX, minRigtY)) / 2;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }

            } else if (maxLeftX > minRigtY) {
                end = partitionX - 1;
            } else {
                start = partitionX + 1;
            }


        }


        return 1;
    }
}
