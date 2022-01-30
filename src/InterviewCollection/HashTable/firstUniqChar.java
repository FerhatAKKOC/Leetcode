package InterviewCollection.HashTable;

import javax.swing.*;
import java.util.*;

public class firstUniqChar {

    public static void main(String[] args) {

        int[] nums1 = new int[]{1, 2, 2, 1, 3, 4, 5, 5, 4, 8};
        int[] nums2 = new int[]{2, 2};

        var output = intersect(nums1, nums2);

        Arrays.stream(output).forEach(System.out::print);

    }

    private static int[] intersect(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null) return null;

        Map<Integer, Integer> map = new HashMap<>();

        for (var num : nums1) {

            var counter = map.getOrDefault(num, 0);
            map.put(num, counter + 1);
        }

        List<Integer> output = new ArrayList<>();

        for (var num : nums2) {

            var val = map.getOrDefault(num, 0);

            if (val > 0) {
                output.add(num);
                map.replace(num, val - 1);
            }
        }

        return  output.stream().mapToInt(i->i).toArray();
    }
}
