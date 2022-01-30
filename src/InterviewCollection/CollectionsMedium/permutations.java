package InterviewCollection.CollectionsMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutations {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        var outputs = permute(nums);
        for (var output : outputs)
            System.out.print(output + ", ");

    }

    /*
        Input: nums = [1,2,3]
        Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */
    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;

        List<Integer> permutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        helper(nums, permutation, used, result);

        return result;
    }

    private static void helper(int[] nums, List<Integer> permutation, boolean[] used, List<List<Integer>> result) {

        if (nums.length == permutation.size()) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;

            used[i] = true;
            permutation.add(nums[i]);
//            System.out.println(permutation);
            helper(nums, permutation, used, result);
            permutation.remove(permutation.size() - 1);
            used[i] = false;
        }
    }
}
