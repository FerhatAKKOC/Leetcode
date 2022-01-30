package InterviewCollection.Graph;

import java.util.*;

public class minimumHeightTrees {

    public static void main(String[] args) {
        int[][] edges = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        int n = 6;

        var out = findMinHeightTrees(n, edges);

        out.forEach(System.out::println);

    }

    /*
        Minimum Height Trees
     */
    private static List<Integer> findMinHeightTrees(int n, int[][] edges) {

        // base cases
        if (n <= 0) return new ArrayList<>();

        if (n == 1)     //this is needed...since when there is only 1 vertex... the indegree of it will be 0..this case is not included in the following discussion...
            return Collections.singletonList(0);

        // Build the graph with the adjacency list
        List<Set<Integer>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adjList.add(new HashSet<>());
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }


        // Initialize the first layer of leaves
        ArrayList<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (adjList.get(i).size() == 1)
                leaves.add(i);

        // Trim the leaves until reaching the centroids
        int remainingNodes = n;

        while (remainingNodes > 2) {

            remainingNodes -= leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<>();

            // remove the current leaves along with the edges
            for (Integer leaf : leaves) {
                // the only neighbor left for the leaf node
                Integer parent = adjList.get(leaf).iterator().next();  // leaf'in bağlı olduğu parent node'u buluyoruz.
                adjList.get(parent).remove(leaf);     // bu leaf'i parent'dan remove edereiz
                if (adjList.get(parent).size() == 1)
                    newLeaves.add(parent);          // Eğer parent'a leaf konumuna gelmişse onu da yeni bir leaves array'e atıyoruz
            }

            // prepare for the next round
            leaves = newLeaves;
        }

        // The remaining nodes are the centroids of the graph
        return leaves;
    }

}
/*
    The distance between two nodes is the number of edges that connect the two nodes.
    The height of a tree can be defined as the maximum distance between the root and all its leaf nodes.
    For the tree-alike graph, the number of centroids is no more than 2.
        1- If the number of nodes is even, then there would be two centroids.
        2- If the number of nodes is odd, then there would be only one centroid.

    Implementation
        Given the above algorithm, we could implement it via the Breadth First Search (BFS) strategy, to trim the leaf nodes layer by layer (i.e. level by level).
        Initially, we would build a graph with the adjacency list from the input.
        We then create a queue which would be used to hold the leaf nodes.
        At the beginning, we put all the current leaf nodes into the queue.
        We then run a loop until there is only two nodes left in the graph.
        At each iteration, we remove the current leaf nodes from the queue. While removing the nodes, we also remove the edges that are linked to the nodes.
            As a consequence, some of the non-leaf nodes would become leaf nodes. And these are the nodes that would be trimmed out in the next iteration.
        The iteration terminates when there are no more than two nodes left in the graph, which are the desired centroids nodes.
 */

