package InterviewCollection.CollectionsEasy;

import InterviewCollection.TreeNode;

public class maxDepth {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Output: " + maxDepth(root));

    }

    private static int maxDepth(TreeNode root) {

        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
