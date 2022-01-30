package InterviewCollection.BinaryTree;

import InterviewCollection.TreeNode;

public class hasPathSum {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));

        System.out.println("Output : " + hasPathSum(root, 22));

    }

    // Path Sum
    private static boolean hasPathSum(TreeNode root, int Target) {
        return hasPathSumHelper(root, Target, 0);
    }

    private static boolean hasPathSumHelper(TreeNode root, int target, int sum) {

        if (root.left == null && root.right == null) {
            sum += root.val;
            System.out.println("Sum with leaf : " + root.val + "  ->  Sum: " + sum);
            return (sum == target) ? true : false;
        }

        boolean left = false;
        boolean right = false;

        if (root.left != null)
            left = hasPathSumHelper(root.left, target, sum + root.val);

        if (root.right != null)
            right = hasPathSumHelper(root.right, target, sum + root.val);

        return left || right;
    }

    //****************************************************************
    //****************************************************************
    private static boolean hasPathSum1(TreeNode root, int targetSum) {

        if (root == null) return false;

        if (root.val == targetSum && root.left == null && root.right == null) return true;
        if (root.val != targetSum && root.left == null && root.right == null) return false;

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);

    }

}
