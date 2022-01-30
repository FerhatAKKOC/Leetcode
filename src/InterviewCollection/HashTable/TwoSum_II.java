package InterviewCollection.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum_II {

    public static void main(String[] args) {
//        int[] nums1 = {1, 2}, nums2 = {-2, -1}, nums3 = {-1, 2}, nums4 = {0, 2};
        int[] nums1 = {0}, nums2 = {0}, nums3 = {0}, nums4 = {0};

        System.out.println("Output : " + fourSumCount(nums1, nums2, nums3, nums4));
    }

    /*
        Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:

        0 <= i, j, k, l < n
        nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
     */
    private static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        List<String> res = new ArrayList<>();
        int n = nums1.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    for (int l = 0; l < n; l++)
                        if ((nums1[i] + nums2[j] + nums3[k] + nums4[l]) == 0)
                            res.add(" " + i + " " + j + " " + k + " " + l);

        System.out.println(res);
        return res.size();

    }

    //************************************************************
    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                res += map.getOrDefault(-1 * (A[i] + B[j]), 0);
            }
        }

        return res;
    }

}
