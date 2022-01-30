package InterviewCollection.Recursions;

import InterviewCollection.TreeNode;

public class searchBST {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));

        TreeNode.preOrder(root);

        System.out.println("Output: " + searchBST(root,5).val);

    }

    private static TreeNode searchBST(TreeNode root, int val) {

        if (root == null || root.val == val) return root;

        if (val > root.val) {

            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }
}
