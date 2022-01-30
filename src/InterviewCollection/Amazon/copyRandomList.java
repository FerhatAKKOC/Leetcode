package InterviewCollection.Amazon;

import java.util.HashMap;
import java.util.Map;

public class copyRandomList {

    static Map<Node, Node> visited = new HashMap<>();

    private static Node copyRandomList(Node head) { // It is like a graph

        // Base case
        if (head == null)
            return head;

        if (visited.containsKey(head)) {
            return visited.get(head);
        }

        Node node = new Node(head.val);
        visited.put(head, node);

        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }


    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}