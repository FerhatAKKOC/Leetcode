package InterviewCollection.Amazon;

import InterviewCollection.TreeNode;

public class validateBST {

    public static void main(String[] args) {

        var root = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));

        System.out.println("Output: " + isValidBST(root));

    }

    /*
        Validate Binary Search Tree
        PreOrder kullanılmıştır.
     */
    private static boolean isValidBST(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) return true;

        if (root.left != null && root.left.val >= root.val) return false;
        if (root.right != null && root.right.val <= root.val) return false;


        boolean left = true, right = true;
        if (root.right != null)
            right = isValidBST(root.right);

        if (root.left != null)
            left = isValidBST(root.left);

        return (left && right);
    }

}
