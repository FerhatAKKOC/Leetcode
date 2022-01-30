package InterviewCollection.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cloneGraph {

    public static void main(String[] args) {

        int[][] adjList = {{2, 4}, {1, 3}, {2, 4}, {1, 3}};
        var zero = new Node(0);
        var zero_clone = cloneGraph(zero);

    }

    /*
        Clone Graph
        Recursive DFS solution
     */
    static Node cloneGraph(Node node) {

        Map<Node, Node> visited = new HashMap<>();
        return dfs(node, visited);
    }

    private static Node dfs(Node node, Map<Node, Node> visited) {

        if (visited.containsKey(node))  // If the node was already visited before. Return the clone from the visited dictionary.
            return visited.get(node);

        var clonedNode = new Node(node.val, new ArrayList());

        visited.put(node, clonedNode);

        for (var neighbor : node.neighbors) {
            clonedNode.neighbors.add(dfs(neighbor, visited));
        }

        return clonedNode;
    }


    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
