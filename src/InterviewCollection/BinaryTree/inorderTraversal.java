package InterviewCollection.BinaryTree;

import InterviewCollection.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorderTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);


        // BinaryTree.inOrder(root);
        inorder_iterate(root);


    }


    private static void inorder(TreeNode root) {

        if (root == null) return;

        inorder(root.left);
        System.out.print(" " + root.val);
        inorder(root.right);
    }

    //******************************************************************
    private static void inorder_iterate(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode curr = root;

        // traverse the tree
        while (curr != null || s.size() > 0) {

            /* Reach the left most Node of the curr Node */
            while (curr != null) {
                s.push(curr);       // sadece left'leri stack'e atmamız yeterlidir.
                curr = curr.left;
            }
            curr = s.pop(); /* Current must be NULL at this point */
            System.out.print(curr.val + " ");
            curr = curr.right;    /* we have visited the node and its left subtree.  Now, it's right subtree's turn */
        }
    }
    //*****************************************************************

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }
}
