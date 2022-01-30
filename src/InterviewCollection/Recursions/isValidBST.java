package InterviewCollection.Recursions;

import InterviewCollection.TreeNode;

public class isValidBST {
    public static void main(String[] args) {


//        TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(10, new TreeNode(7), new TreeNode(16)));
        preOrder(root);

        System.out.println();
        System.out.println("Output : " + isValidBST(root));
    }

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

    private static void preOrder(TreeNode root) {

        if (root == null) return;

        System.out.print(root.val + " -> ");
        preOrder(root.left);
        preOrder(root.right);


    }
}
