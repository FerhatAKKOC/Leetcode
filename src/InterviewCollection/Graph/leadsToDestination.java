package InterviewCollection.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leadsToDestination {

    public static void main(String[] args) {

    }

    enum Color {GRAY, BLACK};

    /*
        All Paths from Source Lead to Destination
        https://leetcode.com/problems/all-paths-from-source-lead-to-destination/solution/
     */
    private static boolean leadsToDestination(int n, int[][] edges, int source, int destination) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        // build a graph
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }

        return leadsToDest(graph, source, destination, new Color[n]);
    }

    private static boolean leadsToDest(List<Integer>[] graph, int node, int dest, Color[] states) {

        // If the state is GRAY, this is a backward edge and hence, it creates a loop.
        if (states[node] != null) {  // Eğer null'dan farklı bir değerse daha önce ziyaret edilmiştir. Mutlaka blak olmalı, gray ise cycle oluşur.
            return states[node] == Color.BLACK;
        }

        // If this is a leaf node, it should be equal to the destination.
        if (graph[node].isEmpty()) {
            return node == dest;
        }

        // Now, we are processing this node. So we mark it as GRAY
        states[node] = Color.GRAY;

        for (int next : graph[node]) {

            // If we get a `false` from any recursive call on the neighbors, we short circuit and return from there.
            if (!leadsToDest(graph, next, dest, states)) {
                return false;
            }
        }

        // Recursive processing done for the node. We mark it BLACK
        states[node] = Color.BLACK;
        return true;
    }
}