package InterviewCollection.CollectionsEasy;

import java.util.*;

public class intersectionOfTwoArraysII {

    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        int[] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};

        var output = intersect(nums1, nums2);

        for (var o : output)
            System.out.print(o + " ");

    }

    private static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();

        for (var num : nums1)
            map.put(num, map.getOrDefault(num, 0) + 1);

        List<Integer> list = new ArrayList<>();
        for (var num : nums2) {

            if (map.containsKey(num)) {
                list.add(num);
                var val = map.get(num);
                if (val == 1)
                    map.remove(num);
                else
                    map.replace(num, val - 1);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
