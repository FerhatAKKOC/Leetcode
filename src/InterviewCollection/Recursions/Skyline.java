package InterviewCollection.Recursions;

import java.util.*;

public class Skyline {


    public static void main(String[] args) {
        int[][] buildings = {{1, 11, 5}, {2, 6, 7}, {3, 13, 9}, {12, 7, 16}, {14, 3, 25}, {19, 18, 22}, {23, 13, 29}, {24, 4, 28}};
       // int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};


        // Function Call
        getSkyline(buildings);
    }

    private static List<int[]> getSkyline(int[][] buildings) {

        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();

        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }

        Collections.sort(height, (a, b) -> {
                    if (a[0] != b[0])
                        return a[0] - b[0];
                    return a[1] - b[1];
                }
        );

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int prev = 0;
        for (int[] h : height) {
            if (h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if (prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }


}

