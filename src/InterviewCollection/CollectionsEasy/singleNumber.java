package InterviewCollection.CollectionsEasy;

import java.util.HashMap;
import java.util.Map;

public class singleNumber {

    public static void main(String[] args) {
//        int[] nums = {4, 1, 2, 1, 2};
//        int[] nums = {2, 2, 1};
        int[] nums = {1};

        System.out.println("Output : " + singleNumber(nums));
    }

    private static int singleNumber(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (var val : map.keySet()) {
            if (map.get(val) == 1)
                return val;
        }

        return 0;
    }

    /*
    XOR operations.
     */
    private static int singleNumber2(int[] nums) {

        int ans =0;

        int len = nums.length;
        for(int i=0;i!=len;i++)
            ans ^= nums[i];

        return ans;
    }
}
