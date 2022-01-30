package InterviewCollection.Amazon;

import InterviewCollection.TreeNode;

public class symmetricTree {

    public static void main(String[] args) {

        var root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)));

        System.out.println("Output: " + isSymmetric(root));
    }

    private static boolean isSymmetric(TreeNode root) {

        return isSymmetric(root, root);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {

        if (left == null && right == null) return true;
        if (left == null || right == null) return false;  // önceki satırı geçmişse ve burada kalıyorsa, sadece 1 tanesi 'null' dur. Burada bir yanlış vardır.
        if (left.val != right.val) return false;

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
