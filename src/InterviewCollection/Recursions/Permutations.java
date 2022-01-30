package InterviewCollection.Recursions;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        permute(arr);

    }

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
            permutation.add(i);
            helper(nums, permutation, used, result);
            permutation.remove(permutation.size() - 1);
            used[i] = false;
        }
    }
}
