package InterviewCollection.HashTable;

import java.util.*;
import java.util.stream.Collectors;

public class topKFrequent {

    public static void main(String[] args) {
        int[] nums = {6, 6, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 8, 4, 4, 4};
        int k = 2;
        topKFrequent(nums, k);
    }

    private static List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());

        map.entrySet().forEach(e -> {
            pq.offer(e);
            if (pq.size() > k)
                pq.poll();

        });
        return pq.stream().map(o -> o.getKey()).collect(Collectors.toList());
    }
}
