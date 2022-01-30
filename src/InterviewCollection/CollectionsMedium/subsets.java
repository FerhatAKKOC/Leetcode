package InterviewCollection.CollectionsMedium;

import java.util.*;
import java.util.stream.Collectors;

public class subsets {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        var outputs = subsets(nums);

        for (var output : outputs)
            System.out.println(output);
    }

    /*
        Input: nums = [1,2,3]
        Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     */
    private static List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();

        backtrack(nums, 0, set, new ArrayList<Integer>());

        return set.stream().collect(Collectors.toList());
    }

    private static void backtrack(int[] nums, int start, Set<List<Integer>> set, ArrayList<Integer> list) {

        if (list.size() > nums.length)
            return;

        Collections.sort(list);
        set.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, i + 1, set, list);
            list.remove(list.size() - 1);
        }
    }

}
