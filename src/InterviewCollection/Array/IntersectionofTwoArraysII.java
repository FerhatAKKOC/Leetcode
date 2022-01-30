package InterviewCollection.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoArraysII {

/*
     Input: nums1 = [4,9,5,4,5], nums2 = [9,4,9,8,4,4,4,4]  Kesişim kümesini geri döner.
     Output: [4,9]
 */

    public static void main(String[] args) {

        int[] nums1 = new int[]{4, 9, 5, 4, 5};
        int[] nums2 = new int[]{9,4,9,8,4,4,4,4};

        var result = intersect(nums1,nums2);

        Arrays.stream(result).forEach(System.out::println);
    }


    // 1. Java Stream API - distinct
    // 2. Java Stream API - count
    // 3. Python 'set()'
    // 4. 2 for loop by using set.contains

    public static int[] intersect(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();

        for (int i : nums1) {

            if (!set.contains(i)){
                for (int j : nums2){
                    if (i == j){
                        set.add(i);
                        break;
                    }
                }
            }
        }
        System.out.println(set);

        //var result  =Arrays.stream(nums1).distinct().boxed().collect(Collectors.toList());
        var res1 = set.stream().mapToInt(value -> value).toArray();
        return res1;
    }
}
