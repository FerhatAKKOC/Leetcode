package InterviewCollection.Array;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 50, 75};

        var output = findMissingRanges(nums, 0, 99);

        output.stream().forEach(System.out::println);
    }

    private static List<String> findMissingRanges(int[] nums, int lower, int higher) {

        List<String> ranges = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (lower < nums[i]) {
                if (lower - nums[i] == 1)
                    ranges.add(lower + "");
                else
                    ranges.add(lower + "->" + (nums[i] - 1));
            }

            lower = nums[i] + 1;

            if (nums[i] == Integer.MAX_VALUE)
                return ranges;
        }

        if (lower == higher)
            ranges.add(higher + "");
        else if (lower < higher)
            ranges.add(lower + "->" + higher);

        return ranges;
    }
}
