package InterviewCollection.HashTable;

import java.util.HashMap;

public class singleNumber {

    public static void main(String[] args) {
        int[] arr = {1, 1, 5, 3, 3, 5, 3, 2, 4, 2};

        System.out.println("Output: " + singleNumber(arr));
    }

    // Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
    private static int singleNumber(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (var val : nums) {

            var temp = map.getOrDefault(val,0);
            map.put(val, ++temp);
        }

        for (var entry : map.entrySet()){
            if(entry.getValue() ==1)
                return entry.getKey();
        }

        return map.get(0);
    }

}
