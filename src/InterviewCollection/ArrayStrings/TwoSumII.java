package InterviewCollection.ArrayStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSumII {

    public static void main(String[] args) {

//        int[] numbers = {2, 7, 11, 15}; int target = 9;
//        int[] numbers = {-1,0}; int target = -1;
        int[] numbers = {2,3,4}; int target = 6;

        var output = twoSum(numbers, target);
        System.out.println(output[0] + " " + output[1]);
    }

    private static int[] twoSum(int[] numbers, int target) {

        if (numbers.length == 2 && ((numbers[0] + numbers[1]) == target)) {
            return new int[]{1, 2};
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {

            int temp = target - numbers[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i + 1};
            } else {
                map.put(numbers[i], i + 1);
            }
        }

        return new int[]{};
    }
}
