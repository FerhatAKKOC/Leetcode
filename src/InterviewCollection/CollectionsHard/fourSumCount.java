package InterviewCollection.CollectionsHard;

import java.util.HashMap;
import java.util.Map;

public class fourSumCount {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};

        var count = fourSumCount(nums1, nums2, nums3, nums4);
        System.out.println("Output: " + count);
    }

    private static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {


        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n1 : nums1)
            for (int n2 : nums2) {
                int s = n1 + n2;
                map.put(s, map.getOrDefault(s, 0) + 1);
            }

        int result = 0;
        for (int n3 : nums3)
            for (int n4 : nums4) {
                int s = -n3 - n4;
                result += map.getOrDefault(s, 0);
            }
        return result;
    }
}
