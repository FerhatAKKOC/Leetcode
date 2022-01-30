package InterviewCollection.BinaryTree;

import InterviewCollection.TreeNode;

public class countUnivalue {

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(5,
                new TreeNode(1, new TreeNode(5), new TreeNode(5)),
                new TreeNode(5, null, new TreeNode(5)));


        TreeNode root2 = new TreeNode(5,
                new TreeNode(4, new TreeNode(4), new TreeNode(4)),
                new TreeNode(5, null, new TreeNode(5)));

        TreeNode root3 = new TreeNode(4, null, new TreeNode(4));

        uniValue(root2);
    }

    // Count Univalue Subtrees
    private static int uniValue(TreeNode root) {

        var result = univalueHelper(root);

        System.out.println("Count : " + result.count + "  Univalues : " + result.univalue);
        return result.count;
    }


    private static Pair univalueHelper(TreeNode node) {

        if (node == null)
            return new Pair(0, true);

        if (node.left == null && node.right == null)
            return new Pair(1, true);
        
        Pair left = univalueHelper(node.left);
        Pair right = univalueHelper(node.right);

        if (left.univalue && right.univalue && node.left.val == node.right.val)
            return new Pair(left.count + right.count + 1, true);


        return new Pair(left.count + right.count, false);
    }
}

class Pair {

    int count;
    boolean univalue;

    public Pair(int count, boolean univalue) {
        this.count = count;
        this.univalue = univalue;
    }
}
