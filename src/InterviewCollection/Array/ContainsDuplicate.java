package InterviewCollection.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    /*
        Input: nums = [1,1,1,3,3,4,3,2,4,2]   There is a duplicate elements, returns true;
        Output: true
     */
    public static void main(String[] args) {


        int[] nums = Arrays.asList(1, 1, 1, 3, 3, 4, 3, 2, 4, 2).stream().mapToInt(value -> value).toArray();
        int[] nums1 = Arrays.asList(1,2,3,4,6).stream().mapToInt(value -> value).toArray();

        System.out.println(containsDuplicate(nums1));
    }

    // 2 nested for loop,
    // HashSet
    // Streams -> distinct


    static boolean containsDuplicate(int[] nums) {

        if (nums == null || nums.length == 1) return false;

        Set<Integer> set = new HashSet<>();

        for (int element : nums) {
            if (set.contains(element)) {
                return true;
            } else {
                set.add(element);
            }
        }

        return false;
    }
}
