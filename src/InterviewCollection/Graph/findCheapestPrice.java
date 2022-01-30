package InterviewCollection.Graph;

import java.util.Arrays;

public class findCheapestPrice {

    public static void main(String[] args) {
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0, dst = 2, k = 1, n = 3;

        System.out.println("Output: " + findCheapestPrice(n, flights, src, dst, k));
    }

    /*
        Cheapest Flights Within K Stops
        Bellman-Ford Algorithm
     */
    private static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] parent = new int[n];
        int[] previous = new int[n];
        int[] current = new int[n];
        Arrays.fill(current, Integer.MAX_VALUE);
        Arrays.fill(previous, Integer.MAX_VALUE);
        previous[src] = 0;
        parent[src] = -1;


        boolean updated = false;
        for (int i = 0; i < k + 1; i++) { // k=1 means 2 edges
            current[src] = 0;
            updated = false;
            for (var flight : flights) {
                int U = flight[0];
                int V = flight[1];
                int wt = flight[2];

                if (previous[V] < Integer.MAX_VALUE && (previous[V] + wt) < current[V]) {
                    current[V] = previous[V] + wt;
                    parent[V] = U;
                    updated = true;
                }
            }

            if (updated == false) break;

            previous = current.clone();

        }

        return -1;
    }


    /*    private static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        if (src == dst) return 0;

        int[] parent = new int[n];
        int[] previous = new int[n];
        int[] current = new int[n]; // cost_parent
        Arrays.fill(parent, 0);
        Arrays.fill(previous, Integer.MAX_VALUE);
        Arrays.fill(current, Integer.MAX_VALUE);
        previous[src] = 0;
        parent[src] = -1;

        boolean updated = false;
        for (int i = 0; i < k + 1; i++) {   // k=1 stop means 2 edges. That means 2 relaxation operations we need

            current[src] = 0;
            updated = false;

            for (var flight : flights) {

                int U = flight[0];
                int V = flight[1];
                int wt = flight[2];

                if (previous[U] < Integer.MAX_VALUE && (previous[U] + wt) < current[V]) {
                    current[V] = previous[U] + wt;
                    parent[V] = U;
                    updated = true;
                }
            }

            if (updated == false) break; // artık değişiklik olmadığından döngüyü kırıyoruz.

            previous = current.clone();
        }


        //Now, check by relaxing once more if we have a negative edge cycle
//        if (updated) {
//            for (var flight : flights) {
//                int U = flight[0];
//                int V = flight[1];
//                int wt = flight[2];
//                if (previous[U] < Integer.MAX_VALUE && (previous[U] + wt) < current[V]) {
//                    System.out.println("Graph has a negative edge-weight cycle");
//                    return -1;
//                }
//            }
//        }

        return current[dst] == Integer.MAX_VALUE ? -1 : current[dst];
    }*/
}
