package InterviewCollection.SortingSearching;

public class merge {


    public static void main(String[] args) {

        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;


        merge(nums1, m, nums2, n);
    }


    /*
        You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

        Merge nums1 and nums2 into a single array sorted in non-decreasing order.

        The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
        To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
        and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
     */
    private static void merge(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0) {

        } else if (m == 0) {
            nums1 = nums2;
        }
        else
        {
            int indt = nums1.length - 1;
            int ind1 = m - 1;
            int ind2 = n - 1;

            while (indt >= 0 && ind1 >= 0 && ind2 >= 0) {

                if (nums2[ind2] >= nums1[ind1]) {
                    nums1[indt] = nums2[ind2];
                    indt--;
                    ind2--;
                }else if (nums2[ind2] < nums1[ind1]){
                    nums1[indt] = nums1[ind1];
                    indt--;
                    ind1--;
                }
            }
        }
    }
}
