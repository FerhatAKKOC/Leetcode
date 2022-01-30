package InterviewCollection.Graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class minCostConnectPoints_Prims {

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
//        int[][] points = {{3, 12}, {-2, 5}, {-4, 1}};

        System.out.println("Output: " + minCostConnectPoints(points));
    }

    /*
        Min Cost to Connect All Points
        Prim's Algorithm
     */
    private static int minCostConnectPoints(int[][] points) {

        if (points == null || points.length == 0)
            return 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        int size = points.length;

        boolean[] visited = new boolean[size];

        var cord1 = points[0];
        for (int i = 1; i < size; i++) {
            var cord2 = points[i];
            var cost = Math.abs(cord1[0] - cord2[0]) + Math.abs(cord1[1] - cord2[1]);
            pq.add(new Edge(0, i, cost));
        }
        visited[0] = true;

        int minCost = 0;
        while (!pq.isEmpty()) {

            Edge edge = pq.poll();
            int point1 = edge.point1;
            int point2 = edge.point2;
            int cost = edge.cost;

            if (!visited[point2]) {
                minCost += edge.cost;
                visited[point2] = true;

                cord1 = points[point2];
                for (int i = 0; i < size; i++) {
                    if(!visited[i]){ // unvisited
                        var cord2 = points[i];
                        cost = Math.abs(cord1[0] - cord2[0]) + Math.abs(cord1[1] - cord2[1]);
                        pq.add(new Edge(point2, i, cost));
                    }
                }
            }
        }

        return minCost;
    }

    static class Edge {
        int point1;
        int point2;
        int cost;

        public Edge(int x, int y, int len) {
            this.point1 = x;
            this.point2 = y;
            this.cost = len;
        }

        @Override
        public String toString() {
            return "Edge{" + "point1=" + point1 + ", point2=" + point2 + ", cost=" + cost + '}';
        }
    }

}
