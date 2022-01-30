package InterviewCollection.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class intersectionTwoArrayII {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1, 3, 4, 5, 6, 6, 6, 6};
        int[] nums2 = {2, 2, 6, 6, 1};

        System.out.println("Output : " + intersectII(nums1, nums2));
    }

    /*
            Input: nums1 = [1,2,2,1], nums2 = [2,2]
            Output: [2,2]

            Previously, check array, return early in some conditions like empty array, lenght==1,
            Create a map
            fill in it with nums1 items
            Traverse on nums2, compare items with map
            If there is a matching items in nums2 and the map, fill in result array, decrease -1 in map

            Test Conditions:
            Empty arrays
            When arrays lengths are 1
            Normal test

            Complexity Calculation:
            Time compl
            Space comp
     */

    private static int[] intersectII(int[] nums1, int[] nums2) {

        List<Integer> result = new ArrayList<>();

        if (nums1 == null || nums2 == null)
            return new int[]{};

        HashMap<Integer, Integer> map = new HashMap<>();

        for (var val : nums1) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        for (var item2 : nums2) {
            if (map.containsKey(item2)) {
                map.put(item2, map.get(item2) - 1);
                result.add(item2);
                if (map.get(item2) == 0)
                    map.remove(item2);
            }
        }

        Stream.of(result).forEach(System.out::println);

        return nums1;
    }
}
