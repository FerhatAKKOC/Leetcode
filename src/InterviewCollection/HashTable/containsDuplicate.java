package InterviewCollection.HashTable;

import java.util.HashSet;
import java.util.Set;

public class containsDuplicate {

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        System.out.println("Output: " + containsDuplicate(arr));
    }

    // Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
    private static boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int val : nums) {
            if (set.contains(val)) {
                return true;
            }
            set.add(val);
        }

        return false;

    }
}
