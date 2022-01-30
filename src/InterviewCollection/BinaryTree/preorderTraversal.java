package InterviewCollection.BinaryTree;

import InterviewCollection.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preorderTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        preOrder(root);

    }

    private static void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(" " + root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    //************************************************************
    //************************************************************

    // Root->Left->Right
    private static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode temp = stack.pop();
            list.add(temp.val);

            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return list;
    }

    //************************************************************
    //************************************************************

    // Root->Left->Right
    private static List<Integer> preorderTraversal1(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            var temp = stack.pop();

            System.out.print(" " + temp.val);

            if (temp.left != null)
                stack.push(temp.left);

            if (temp.right != null)
                stack.push(temp.right);
        }
        return null;
    }
}
