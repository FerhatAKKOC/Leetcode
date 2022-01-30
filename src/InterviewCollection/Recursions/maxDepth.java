package InterviewCollection.Recursions;

import InterviewCollection.TreeNode;

public class maxDepth {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7, new TreeNode(12), null)));

        TreeNode.preOrder(root);

        System.out.println("Output : " + maxDepth(root));
    }

    private static int maxDepth(TreeNode root) {


        if (root.left == null && root.right == null)
            return 1;

        int leftDepth = 0;
        int rightDepth = 0;

        if (root.right != null)
            rightDepth = maxDepth(root.right);
        if (root.left != null)
            leftDepth = maxDepth(root.left);

        return Integer.max(leftDepth, rightDepth) + 1;

    }
}
