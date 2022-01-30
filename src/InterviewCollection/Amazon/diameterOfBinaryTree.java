package InterviewCollection.Amazon;

import InterviewCollection.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class diameterOfBinaryTree {

    public static void main(String[] args) {

        var root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
//        var root = new TreeNode(1, new TreeNode(2), null);

        System.out.println("Output: " + diameterOfBinaryTree(root));
    }

    /*
    Diameter of Binary Tree
     */
    private static int diameterOfBinaryTree(TreeNode root) {

        if (root == null)
            return 0;

        int left = bfs(root.left);
        int right = bfs(root.right);

        return left + right;
    }

    private static int bfs(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;
        while (!queue.isEmpty()) {

            var size = queue.size();
            depth++;
            while (size-- > 0) {

                var node = queue.poll();

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        System.out.println("Dpeth: " + depth);
        return depth;
    }
}
