package InterviewCollection.CollectionsHard;

import InterviewCollection.TreeNode;

public class maxPathSum {

    public static void main(String[] args) {

        var root = new TreeNode(-10,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        maxSumPath(root);
        System.out.println("Output: " + maxSum);

    }

    /*
        Binary Tree Maximum Path Sum
        https://www.youtube.com/watch?v=TO5zsKtc1Ic

        Post Order Processing
     */
    private static Integer maxSum = Integer.MIN_VALUE;

    private static int maxSumPath(TreeNode node) {

        if (node == null)
            return 0;

        int left = maxSumPath(node.left);
        int right = maxSumPath(node.right);

        int root = node.val;

        int returningMax = Math.max(Math.max(left, right) + root, root);  // her iki çocuk negatif, root pozitif olabilir.
        int localMax = Math.max(returningMax, left + right + root);

        maxSum = Math.max(localMax, maxSum);

        System.out.println("node: " + root + "  returningMax: " + returningMax + "  localMax: " + localMax + "  maxSum:" + maxSum);

        return returningMax;
    }
}
