package InterviewCollection.Amazon;

import java.util.*;

public class topKFrequent {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 3, 3, 3, 3};
        int k = 2;

        var out = topKFrequent(nums, k);
        Arrays.stream(out).forEach(value -> System.out.print(value + " "));
    }

    /*
        Top K Frequent Elements
     */
    private static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (var val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        pq.addAll(map.entrySet());

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().getKey();
        }




        return result;
    }
}
