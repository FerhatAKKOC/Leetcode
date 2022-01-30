package InterviewCollection.Graph;

import java.util.*;

public class networkDelayTime {

    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4, k = 2;

        System.out.println("Output: " + networkDelayTime(times, n, k));
    }

    /*
        Network Delay Time
        Dijkstra's Algorithm
     */
    private static int networkDelayTime(int[][] times, int N, int K) {

        Map<Integer, List<int[]>> graph = new HashMap<>();  // src -> List{dest, wight}. Bir node'un komşuları ve distance'ları
        // Build a graph
        for (var edge : times) {
            int src = edge[0], dest = edge[1], len = edge[2];
            graph.putIfAbsent(src, new ArrayList<>());
            graph.get(src).add(new int[]{dest, len});
        }

        Map<Integer, Integer> visited = new HashMap<>(); // node, distance(shortest)

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);  //dest, weight. pq o anki visited'a eklenmemiş node değerlerinide tutar.
        pq.offer(new int[]{K, 0}); // first destination is K and its weight is '0'

        while (!pq.isEmpty()) {

            var curr = pq.poll();
            int node = curr[0], weight = curr[1];

            if (visited.containsKey(node)) continue;  // Daha önce ziyaret edilmiş bir node ise, pass geçiyoruz.

            visited.put(node, weight); // Daha önce ziyaret edilmediğinden, ekliyoruz.
            if (graph.containsKey(node)) {
                for (var edge : graph.get(node)) {
                    int neighbour = edge[0], dist = edge[1];
                    if (!visited.containsKey(neighbour)) { // Taradğımız komşu daha önce ziyaret edilmemiş olsun.
                        pq.offer(new int[]{neighbour, dist + weight});
                    }
                }
            }
        }

        if (visited.size() != N) // bütün node'ları ziyaret edememişsek, hepsine sinyal gönderememişsek -1 dönüyoruz.
            return -1;
        return Collections.max(visited.entrySet(), Map.Entry.comparingByKey()).getKey();
    }

}
