package InterviewCollection.CollectionsMedium;

import InterviewCollection.TreeNode;

import java.util.*;

public class zigzagLevelOrder {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
//        TreeNode root = new TreeNode(3);


        var output = zigzagLevelOrder(root);

        for (var out : output)
            System.out.print(out + ", ");
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        if (root == null) return list;
        if (root.left == null && root.left == null) {
            list.add(Arrays.asList(root.val));
            return list;
        }

        Deque<TreeNode> rqueue = new ArrayDeque();
        Deque<TreeNode> lqueue = new ArrayDeque();

        rqueue.offer(root);

        while (!rqueue.isEmpty() || !lqueue.isEmpty()) {

            if (rqueue.size() > 0) {
                List<Integer> arr = new ArrayList<>();
                while (!rqueue.isEmpty()) {
                    var node = rqueue.poll();
                    arr.add(node.val);

                    if (node.right != null) lqueue.offer(node.right);
                    if (node.left != null) lqueue.offer(node.left);
                }
                list.add(arr);
            }

            if (lqueue.size() > 0) {
                List<Integer> arr = new ArrayList<>();
                while (!lqueue.isEmpty()) {
                    var node = lqueue.poll();
                    arr.add(node.val);

                    if (node.left != null) rqueue.offer(node.left);
                    if (node.right != null) rqueue.offer(node.right);
                }
                list.add(arr);
            }
        }
        return list;
    }
}
