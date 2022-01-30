package InterviewCollection.Graph;

import java.util.*;

public class FindIfPathExists {

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        int start = 0, end = 5;
        int n = 6;

        System.out.println("Output: " + validPath(n, edges, start, end));
    }

    /*
        Find if Path Exists in Graph
        Iterative DFS using stack.
     */
    private static boolean validPath(int n, int[][] edges, int start, int end) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (var edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        while (!stack.isEmpty()) {

            var top = stack.pop();
            if (top == end)
                return true;
            for (var child : map.get(top)) {
                if (!visited[child]) {
                    visited[child] = true;
                    stack.push(child);
                }
            }
        }

        return false;
    }

    /*
        Union Find
    */
    private static boolean validPath2(int n, int[][] edges, int start, int end) {

        UnionFind uf = new UnionFind(n);

        for (var edge : edges) {
            uf.union(edge[0],edge[1]);
        }
        return uf.isConnected(start,end);
    }
}
