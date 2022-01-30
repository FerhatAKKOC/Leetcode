package InterviewCollection.BinaryTree;

import InterviewCollection.TreeNode;

import java.util.*;

public class levelOrderTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(12);
        root.right.left = new TreeNode(16);
        root.right.right = new TreeNode(25);

        levelOrder(root);
    }


    private static List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root == null) return null;

        queue.offer(root);

        while (queue.size() > 0) {

            TreeNode temp = queue.poll();
            System.out.print(" -> " + temp.val);

            if (temp.left != null)
                queue.offer(temp.left);

            if (temp.right != null)
                queue.offer((temp.right));
        }

        return null;
    }

    // Level Tutuyoruz.
    public List<List<Integer>> levelOrder1(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        LinkedList<Integer> levelQueue = new LinkedList<>();

        nodeQueue.offer(root);
        levelQueue.offer(1);//start from 1

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int level = levelQueue.poll();

            List<Integer> l = null;
            if (result.size() < level) {
                l = new ArrayList<>();
                result.add(l);
            } else {
                l = result.get(level - 1);
            }

            l.add(node.val);

            if (node.left != null) {
                nodeQueue.offer(node.left);
                levelQueue.offer(level + 1);
            }

            if (node.right != null) {
                nodeQueue.offer(node.right);
                levelQueue.offer(level + 1);
            }
        }

        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {

        if (root == null) return null;
        List<List<Integer>> result = new ArrayList<>();
        Queue<AbstractMap.SimpleEntry<TreeNode, Integer>> queue = new ArrayDeque<>();

        queue.offer(new AbstractMap.SimpleEntry<>(root,1));

        while (queue.size()>0){

            var temp = queue.poll();
            var level = temp.getValue();
            var node = temp.getKey();
            List<Integer> list = null;
            if(result.size()<level){
                list = new ArrayList<>();
            }else {
                list = result.get(level-1);
            }

            list.add(node.val);

            result.add(list);

            if(node.left != null)
                queue.offer(new AbstractMap.SimpleEntry<>(node.left,level+1));

            if(node.right != null)
                queue.offer(new AbstractMap.SimpleEntry<>(node.right,level+1));
        }

        return result;
    }

}
