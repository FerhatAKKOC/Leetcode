package InterviewCollection.BinaryTree;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Queue;

public class connectNext {

    //  Populating Next Right Pointers in Each Node
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2, new Node(4), new Node(5));
        root.right = new Node(3, null, new Node(7));

        connectII(root);

    }

    // perfect binary tree
    private static Node connectI(Node root) {

        if (root == null)
            return null;

        var current = root;

        while (current.left != null) {  // levels

            Node nextLevel = current.left;

            while (current != null) {

                current.left.next = current.right;

                if (current.next == null)
                    current.right.next = null;
                else
                    current.right.next = current.next.left;

                current = current.next;
            }
            current = nextLevel;
        }

        return root;
    }

    // Not a Perfect Nodes.
    private static Node connectII(Node root) {

        if (root == null) return null;

        Queue<AbstractMap.SimpleEntry<Node, Integer>> queue = new ArrayDeque<>();

        queue.offer(new AbstractMap.SimpleEntry<>(root, 1));

        do {

            var temp = queue.poll();
            var currentNode = temp.getKey();
            var currentLevel = temp.getValue();

            if (currentNode.left != null)
                queue.offer(new AbstractMap.SimpleEntry<>(currentNode.left, currentLevel + 1));
            if (currentNode.right != null)
                queue.offer(new AbstractMap.SimpleEntry<>(currentNode.right, currentLevel + 1));

            var nextCurr = queue.peek();
            var nextLevel = (nextCurr != null) ? nextCurr.getValue() : null;

            if (currentLevel == nextLevel) {
                var nextNode = nextCurr.getKey();
                currentNode.next = nextNode;
            }
        }
        while (queue.size() > 0);

        return root;
    }


    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
            next = null;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
