package InterviewCollection.CollectionsHard;

import InterviewCollection.TreeNode;

public class lowestCommonAncestor {

    public static void main(String[] args) {

        var root = new TreeNode(3,
                new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
                new TreeNode(1, new TreeNode(0), new TreeNode(8)));


        var ans = lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4));

        System.out.println("Output: " + ans.val);
    }

    private static TreeNode ans = null;

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        recurseTree(root, p, q);
        return ans;
    }

    private static boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        if (currentNode == null)
            return false;

        boolean mid = currentNode.val == p.val || currentNode.val == q.val;

        boolean left = recurseTree(currentNode.left, p, q);
        boolean right = recurseTree(currentNode.right, p, q);

        if (mid && (left || right) || (left && right))
            ans = currentNode;

        return (mid || left || right);
    }
}
