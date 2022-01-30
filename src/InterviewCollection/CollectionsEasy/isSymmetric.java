package InterviewCollection.CollectionsEasy;

import InterviewCollection.TreeNode;

public class isSymmetric {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3))
        );
    }

    /*
        Symmetric Tree
     */
    private static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private static boolean isMirror(TreeNode left, TreeNode right) {

        if (left == null && right == null) return true;
        if (left == null || right == null) return false;

        // İlk çocuklar direk karşılaştırılacaklar. Sonra çocukların left-right children'ları recursive şekilde karşılaştırılacaklar
        return (left.val == right.val) && isMirror(left.right, right.left) && isMirror(left.left, right.right);
    }
}
