package InterviewCollection.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAryLevelOrder {

    /*
        N-ary Tree Level Order Traversal
     */
    private static List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> outerList = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            List<Integer> innerList= new ArrayList<>();
            var size = queue.size();

            for (int i = 0; i <size ; i++) {

                Node node = queue.poll();
                innerList.add(node.val);

                queue.addAll(node.children);
            }
            outerList.add(innerList);
        }

        return outerList;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
