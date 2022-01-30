package InterviewCollection.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class populatingNextRightPointers {

    public static void main(String[] args) {
        var left = new Node(2, new Node(4), new Node(5));
        var right = new Node(3, new Node(6), new Node(7));
        var root = new Node(1, left, right);

        root = connect(root);

    }

    /*
        Populating Next Right Pointers in Each Node
     */
    private static Node connect(Node root) {

        if (root == null) return root;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            var size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                if (i < size)
                    node.next = queue.peek();// the root/rightmost zaten default olarak null'dur

                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
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
