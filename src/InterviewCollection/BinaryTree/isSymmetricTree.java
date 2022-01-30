package InterviewCollection.BinaryTree;

import InterviewCollection.TreeNode;

public class isSymmetricTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));

        System.out.println("Output : " + isSymmetric(root, root));
    }

    //Symmetric Tree
    private static boolean isSymmetric(TreeNode left, TreeNode right) {

        if (left == null && right == null) return true;
        if (left == null || right == null) return false;   // sadece bir tanesi 'null' ise, burada bir yanlış vardır.
        if (left.val != right.val) return false;

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
