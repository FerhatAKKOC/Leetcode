package InterviewCollection.Amazon;

import InterviewCollection.TreeNode;

public class maxPathSum {

    public static void main(String[] args) {

        var root = new TreeNode(-10,
                new TreeNode(9, new TreeNode(5, new TreeNode(6), new TreeNode(3)), null),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));

    }

    /*
        Binary Tree Maximum Path Sum
        https://www.youtube.com/watch?v=TO5zsKtc1Ic

        Post Order Processing
     */
    private static Integer globalMax = Integer.MIN_VALUE;

    private static int maxPathSum(TreeNode root) {

        if (root == null)
            return 0;

        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);

        int returningMax = Math.max(Math.max(left, right) + root.val, root.val);
        int localMax = Math.max(left + right + root.val, returningMax);

        globalMax = Math.max(globalMax, localMax);

        return returningMax;
    }
}
