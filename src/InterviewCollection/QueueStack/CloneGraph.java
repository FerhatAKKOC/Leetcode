package InterviewCollection.QueueStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    public static void main(String[] args) throws CloneNotSupportedException {

    }

    public Node cloneGraph(Node node) {

        if (node == null) return null;
        Map<Integer, Node> map = new HashMap<>();
        return cloneGraph(node, map);
    }

    private Node cloneGraph(Node node, Map<Integer, Node> map) {

        if (map.containsKey(node.val)) return map.get(node.val);  // returns 'Node'

        Node clone = new Node(node.val);
        map.put(node.val, clone);

        for (var neig : node.neighbors) {
            clone.neighbors.add(cloneGraph(neig, map));
        }
        return clone;
    }


    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(Node node) {
            val = node.val;
            neighbors = new ArrayList<Node>(node.neighbors);
        }

        public Node(int _val) {
            this.val = _val;
            this.neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

    }
}
