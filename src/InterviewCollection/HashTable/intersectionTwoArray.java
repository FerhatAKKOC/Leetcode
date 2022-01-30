package InterviewCollection.HashTable;

import java.util.HashSet;

public class intersectionTwoArray {

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        var output = intersection(nums1, nums2);

//        Arrays.stream(output).forEach(System.out::println);
    }

    private static int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) set2.add(n);


        set1.retainAll(set2);


        int [] output = new int[set1.size()];
        int idx = 0;
        for (int s : set1) output[idx++] = s;
        return output;
    }

}
