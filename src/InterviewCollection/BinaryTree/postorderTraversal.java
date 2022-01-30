package InterviewCollection.BinaryTree;

import InterviewCollection.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class postorderTraversal {

    public static void main(String[] args) {

        TreeNode root = null;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        postOrderIterative(root).forEach(System.out::print);

    }

    public static void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(" " + root.val);
    }

    //*************************************************************
    //*************************************************************

    private static ArrayList<Integer> postOrderIterative(TreeNode root) {

        if (root == null)
            return null;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> nodeStack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode temp = stack.pop();
            nodeStack.add(temp.val);

            if (temp.left != null) {
                stack.push(temp.left);
            }

            if (temp.right != null) {
                stack.push(temp.right);
            }

        }

        var stackToList = new ArrayList(nodeStack);
        Collections.reverse(stackToList);

        return stackToList;
    }
}
