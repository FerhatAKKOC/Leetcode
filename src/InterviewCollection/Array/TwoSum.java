package InterviewCollection.Array;

import java.util.HashSet;

public class TwoSum {


    public static void main(String[] args) {

        //Input: nums = [1, 7, 11, 15, 2, 4], target = 9  (Toplamı 9 olan indice'leri bul.)
        // Output: [1,4]

        int target = 9;
        int[] nums = new int[]{1, 7, 11, 15, 2};

        var res = twoSum(nums, target);
        System.out.println(res[0] + "," + res[1]);

    }

    public static int[] twoSum(int[] nums, int target) {

        if (nums == nums || nums.length == 1)
            return null;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return null;
    }


    // HashSet, olabilirliğini göstgeriyor. HashMap ile daha hızlı çözüm olabilir.
    private boolean sumsToTarget(int[] arr, int k) {

        if(arr == null || arr.length == 1) return false;

        HashSet<Integer> values = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (values.contains(k - arr[i]))
                return true;
            values.add(arr[i]);
        }
        return false;
    }


}
