package InterviewCollection.Amazon;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;

public class kClosest {

    public static void main(String[] args) {
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;

        var outputs = kClosest(points, k);

        for (var out : outputs)
            System.out.println(out[0] + " " + out[1]);

    }

    /*
        K Closest Points to Origin
     */
    private static int[][] kClosest(int[][] points, int k) {

        PriorityQueue<AbstractMap.SimpleEntry<Integer, int[]>> pq = new PriorityQueue<>((o1, o2) -> o1.getKey() - o2.getKey()); // min-heap

        for (var point : points) {
            int sum = (int) (Math.pow(point[0], 2) + Math.pow(point[0], 2));
            pq.offer(new AbstractMap.SimpleEntry<>(sum, new int[]{point[0], point[1]}));
        }
    /*
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
            for (int[] p : points) {
                pq.offer(p);
                if (pq.size() > k) {
                    pq.poll();
                }
            }*/

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            var poll = pq.poll();

            result[i] = poll.getValue();

        }

        return result;
    }

}
