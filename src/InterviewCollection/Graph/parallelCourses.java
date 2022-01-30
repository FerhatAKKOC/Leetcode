package InterviewCollection.Graph;

import java.util.*;

public class parallelCourses {

    public static void main(String[] args) {
//        int[][] relations = {{1, 2}, {2, 3}, {3, 1}}; // cycle
        int[][] relations = {{1, 3}, {2, 3}};
        int n = 3;

        System.out.println("Output: " + minimumSemesters(n, relations));
    }

    /*
        Parallel Courses
     */
    private static int minimumSemesters(int n, int[][] relations) {

        if (n == 1 || relations == null || relations.length == 0)
            return 1;   // birden ok course'da olsa, arada bir bağlantı yoksa hepsini direk dönebilirim.

        // build relationship
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        for (var relation : relations) {
            int prev = relation[0];
            int next = relation[1];
            adjList.putIfAbsent(next, new HashSet<>());
            adjList.putIfAbsent(prev, new HashSet<>());
            adjList.get(next).add(prev);
            adjList.get(prev).add(next);
        }
        int[] indegree = new int[n + 1];

        // find indegree of each nodes
        for (var relation : relations) {
            indegree[relation[1]] = adjList.get(relation[1]).size();
        }

        // push zero-indegree into queueu
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        int semesters = 0;
        int studiedCount = 0;
        while (!queue.isEmpty()) {

            semesters++;
            Queue<Integer> new_queue = new LinkedList<>();

            for (var course : queue) {

                studiedCount++;
                if (adjList.get(course).size() > 0) { // parent var mı yok mu kontrol edilir.

                    int parent = adjList.get(course).iterator().next();  // get parent(3)
                    adjList.get(parent).remove(course); // parent'dan bu course remove edildi. yani, 3 nolu course setinden 1 nolu course remove edildi.

                    indegree[parent]--;

                    if (indegree[parent] == 0)
                        new_queue.offer(parent);
                }
            }
            queue = new_queue;
        }

        return studiedCount == n ? semesters : -1;
    }

    /*
        Approach 2: Depth-First Search: Check for Cycles + Find Longest Path

        The number of semesters needed is equal to the length of the longest path in the graph.

        So firstly, we need to check if the graph has a cycle. If it does, we can directly return -1 since we can never finish all courses.

        Now we break the problem into two parts:

        Check if the graph has a cycle
        Calculate the length of the longest path
        Each of the two parts can be done with DFS. In Approach 3, we will show how to achieve those two-part simultaneously in one single DFS. However, in this approach, for a better understanding, we separate them into two separate DFS traverals.
        Check If the Graph Has A Cycle
        Each node has one of the three states: unvisited, visiting, and visited.
        Before the DFS, we initialize all nodes in the graph to unvisited.
        When performing a DFS, we mark the current node as visiting until we search all paths out of the node from the node. If we meet a node marked with processing, it must come from the upstream path and therefore, we've detected a cycle.
        If DFS finishes, and all node are marked as visited, then the graph contains no cycle.
        Calculate the Length of the Longest Path
        The DFS function should return the maximum out of the recursive calls for its child nodes, plus one (the node itself).
        In order to prevent redundant calculations, we need to store the calculated results. This is an example of dynamic programming, as we're storing the result of subproblems.

    Algorithm
        Step 1: Build a directed graph from relations.
        Step 2: Implement a function dfsCheckCycle to check whether the graph has a cycle.
        Step 3: Implement a function dfsMaxPath to calculate the length of the longest path in the graph.
        Step 4: Call dfsCheckCycle, return -1 if the graph has a cycle.
        Step 5: Otherwise, call dfsMaxPath. Return the length of the longest path in the graph.

     */

    public int minimumSemesters2(int N, int[][] relations) {
        List<List<Integer>> graph = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; ++i) {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] relation : relations) {
            graph.get(relation[0]).add(relation[1]);
        }
        // check if the graph contains a cycle
        int[] visited = new int[N + 1];             // states: unvisited(0), visiting(-1), and visited(1).
        for (int node = 1; node < N + 1; node++) {
            // if has cycle, return -1
            if (dfsCheckCycle(node, graph, visited) == -1) {
                return -1;
            }
        }

        // if no cycle, return the longest path
        int[] visitedLength = new int[N + 1];
        int maxLength = 1;
        for (int node = 1; node < N + 1; node++) {
            int length = dfsMaxPath(node, graph, visitedLength);
            maxLength = Math.max(length, maxLength);
        }
        return maxLength;
    }

    private int dfsCheckCycle(int node, List<List<Integer>> graph, int[] visited) {
        // return -1 if has a cycle
        // return 1 if does not have any cycle
        if (visited[node] != 0) {
            return visited[node];  // visiting(-1), and visited(1) de hit edebilir. visiting(-1) de hit etmişse cycle var demektir.
        } else {
            // mark as visiting
            visited[node] = -1;
        }
        for (int endNode : graph.get(node)) {
            if (dfsCheckCycle(endNode, graph, visited) == -1) {
                // we meet a cycle!
                return -1;
            }
        }
        // mark as visited
        visited[node] = 1;
        return 1;
    }

    /*
        Calculate the Length of the Longest Path
        The DFS function should return the maximum out of the recursive calls for its child nodes, plus one (the node itself).
        In order to prevent redundant calculations, we need to store the calculated results. This is an example of dynamic programming, as we're storing the result of subproblems.
     */
    private int dfsMaxPath(int node, List<List<Integer>> graph, int[] visitedLength) {
        // return the longest path (inclusive) Used for memory
        if (visitedLength[node] != 0) {
            return visitedLength[node];
        }
        int maxLength = 1;
        for (int endNode : graph.get(node)) {
            int length = dfsMaxPath(endNode, graph, visitedLength);
            maxLength = Math.max(length + 1, maxLength);
        }
        // store it
        visitedLength[node] = maxLength;
        return maxLength;
    }
}
