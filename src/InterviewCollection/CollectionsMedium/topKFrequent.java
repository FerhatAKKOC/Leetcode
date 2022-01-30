package InterviewCollection.CollectionsMedium;

import java.util.*;
import java.util.stream.Collectors;

public class topKFrequent {

    public static void main(String[] args) {
        int[] nums = {0, 4, 4, 1, 1, 1, 2, 2, 3};
        int k = 2;
        var output = topKFrequent(nums, k);

        output.forEach(System.out::println);
    }

    private static List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (var val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
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
