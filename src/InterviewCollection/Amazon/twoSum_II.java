package InterviewCollection.Amazon;

import java.util.HashMap;
import java.util.Map;

public class twoSum_II {

    public static void main(String[] args) {

//        int[] numbers = {2, 7, 11, 15}; int target = 9;
        int[] numbers = {2, 3, 4}; int target = 6;

        var out = twoSum2(numbers, target);
        System.out.println(out[0] + " " + out[1]);
    }

    /*
        Two Sum II - Input array is sorted
     */
    private static int[] twoSum(int[] numbers, int target) {

        int[] res = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

//        map.put(0, numbers[0]);
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]), i};
            } else {
                map.put(numbers[i], i);
            }
        }
        return res;
    }

    /*
        We use two indices, initially pointing to the first and the last element, respectively.
        Compare the sum of these two elements with target. If the sum is equal to target, we found the exactly only solution.
        If it is less than target, we increase the smaller index by one.
        If it is greater than target, we decrease the larger index by one.
        Move the indices and repeat the comparison until the solution is found.
     */
    private static int[] twoSum2(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];
            if (sum == target)
                return new int[]{left, right};
            else if (sum < target)
                left++;
            else
                right--;
        }

        return new int[]{};
    }
}
