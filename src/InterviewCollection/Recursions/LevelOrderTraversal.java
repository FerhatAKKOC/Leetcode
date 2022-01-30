package InterviewCollection.Recursions;

import InterviewCollection.TreeNode;

import java.util.*;

public class LevelOrderTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        var levels = levelOrder(root);

        for (var level : levels) {
            for (var num : level)
                System.out.print(num + " -> ");
            System.out.println();
        }

    }

    private static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        if (root == null)
            return list;

        Deque<Pair> deque = new ArrayDeque();
        deque.offer(new Pair(root, 0));

        while (!deque.isEmpty()) {

            var pair = deque.poll();
            var node = pair.node;
            var level = pair.level;


            if (level >= list.size())
                list.add(new ArrayList<>());

            var levelList = list.get(level);

            levelList.add(node.val);

            if (node.left != null)
                deque.offer(new Pair(node.left, level + 1));
            if (node.right != null)
                deque.offer(new Pair(node.right, level + 1));
        }
        return list;
    }
}

class Pair {
    TreeNode node;
    Integer level;

    public Pair(TreeNode node, Integer level) {
        this.node = node;
        this.level = level;
    }
}