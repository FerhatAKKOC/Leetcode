package InterviewCollection.Graph;

import java.util.*;

public class countComponents {

    public static void main(String[] args) {
//        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        int n = 5;
//        System.out.println("Output: " + countComponents(n, edges));
        System.out.println("Output: " + countComponentsDFS(n, edges));
    }

    private static int countComponents(int n, int[][] edges) {

        int[] root = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = -1;
            rank[i] = 1;
        }

        for (var edge : edges) {
            union(root, rank, edge[0], edge[1]);
        }
//        count = n;
//        System.out.println("Count: " + count);
        return (int) Arrays.stream(root).filter(value -> value == -1).count();
    }

    //*****************************************************
    //    UnionFind
    //*****************************************************
    private static int find(int[] root, int x) {
        if (root[x] == -1)
            return x;
        return root[x] = find(root, root[x]);
    }

//    static int count = 0;

    private static void union(int[] root, int[] rank, int x, int y) {

        int rootX = find(root, x);
        int rootY = find(root, y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY])
                root[rootY] = rootX;
            else if (rank[rootX] < rank[rootY])
                root[rootX] = rootY;
            else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
//            count--;
        }
    }

    //*****************************************************
    //    DFS Solutions
    //*****************************************************
    private static int countComponentsDFS(int n, int[][] edges) {

        List<List<Integer>> adjacents = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacents.add(new ArrayList<>());
        }
        for (var edge : edges) {
            adjacents.get(edge[0]).add(edge[1]);
            adjacents.get(edge[1]).add(edge[0]);
        }

        int[] visited = new int[n];

        int counter = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                counter++;
                countComponentsDFS(adjacents, visited, i);
            }
        }

        return counter;
    }

    private static void countComponentsDFS(List<List<Integer>> adjacents, int[] visited, int node) {

        visited[node] = 1;

        for (var adj : adjacents.get(node)) {
            if (visited[adj] == 0)
                countComponentsDFS(adjacents, visited, adj);
        }
    }
}
