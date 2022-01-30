package InterviewCollection.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class allPathsSourceTarget {

    public static void main(String[] args) {
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        var outputs = allPathsSourceTarget(graph);
        for (var output : outputs) {
            System.out.println(output);
        }
    }

    /*
        Backtracking - DFS
        All Paths From Source to Target
     */
    private static List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, path, result);
        return result;
    }

    private static void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> result) {

        // Base Case
        if (node == graph.length - 1) {    // (currNode == target) son noda ulaşınca ekleme yapıyoruz.
            result.add(new ArrayList<>(path));
            return;
        }

        for (var nextNode : graph[node]) {
            path.add(nextNode);
            dfs(graph, nextNode, path, result);
            path.remove(path.size() - 1);
        }
    }

    /*
        BFS
     */
    private static List<List<Integer>> allPathsSourceTarget2(int[][] graph) {

        List<List<Integer>> paths = new ArrayList<>();
        if (graph == null || graph.length == 0)
            return paths;

        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        queue.add(path);

        while (!queue.isEmpty()) {

            var nodePathList = queue.poll();
            var node = nodePathList.get(nodePathList.size() - 1);

            for (var nextNode : graph[node]) {

                var tempPath = new ArrayList<>(nodePathList);
                tempPath.add(nextNode);
                if (nextNode == graph.length - 1) {  // son node'a ulaştık. Artık bunu queue'ya eklemiyoruz.
                    paths.add(new ArrayList<>(tempPath));  //  ne başta yarattığımız List<List<Integer>> ekliyoruz.
                } else {
                    queue.add(new ArrayList<>(tempPath));
                }
            }
        }
        return paths;
    }
}
