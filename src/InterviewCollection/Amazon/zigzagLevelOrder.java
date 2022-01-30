package InterviewCollection.Amazon;

import InterviewCollection.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class zigzagLevelOrder {

    public static void main(String[] args) {

        var root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        var outputs = zigzagLevelOrder(root);
        for (var output : outputs)
            System.out.print(output + ", ");

    }

    /*
         Binary Tree Zigzag Level Order Traversal
     */
    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            var size = queue.size();

            List<Integer> tempList = new ArrayList<>();
            while (size-- > 0) {
                var node = queue.poll();
                tempList.add(node.val);

                if (list.size() % 2 == 0) {
                    if (node.right != null) queue.offer(node.right);
                    if (node.left != null) queue.offer(node.left);
                } else {
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
            }
            list.add(tempList);
        }
        return list;
    }
}
