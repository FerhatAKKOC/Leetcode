package InterviewCollection.BinarySearch;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class FindKthSmallestPairDistance {

    public static void main(String[] args) {

        int[] nums = {1, 6, 1};
        int k = 1;

        System.out.println("Output : " + smallestDistancePair(nums, k));
    }


    private static int smallestDistancePair(int[] nums, int k) {

        SortedSet<Integer> sortedSet = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                sortedSet.add(Math.abs(nums[i] - nums[j]));
            }
        }

        System.out.println(sortedSet);
        int idx = 0;
        Iterator<Integer> i = sortedSet.iterator();
        while (i.hasNext()) {
            if (idx == k)
                return i.next();
            i.next();
            idx++;
        }

        return sortedSet.first();
    }
}
