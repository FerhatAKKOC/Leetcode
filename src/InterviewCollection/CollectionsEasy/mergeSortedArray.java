package InterviewCollection.CollectionsEasy;

public class mergeSortedArray {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0}; int m = 3;
        int[] nums2 = {2, 5, 6}; int n = 3;

//        int[] nums1 = {1}; int m = 1;
//        int[] nums2 = {};  int n = 0;

//          int[] nums1 = {0}; int m = 0;
//          int[] nums2 = {1};  int n = 1;

        mergeSortedArray(nums1, m, nums2, n);

        for (var num : nums1)
            System.out.print(num + " ");
    }

    /*
        Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        Output: [1,2,2,3,5,6]
     */
    private static void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0) return;

        int last = nums1.length - 1;

        m -= 1;
        n -= 1;

        while (0 <= n) {

            if (nums1[m] < nums2[n]) {
                nums1[last] = nums2[n];
                n--;
            } else {
                nums1[last] = nums1[m];
                m--;
            }
            last--;
        }
    }
}
