package InterviewCollection.Amazon;

import InterviewCollection.TreeNode;

public class LCA {


    /*
        Lowest Common Ancestor of a Binary Tree
        InOrder
     */
    private TreeNode LCA = null;

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        if (currentNode == null) {  // If reached the end of a branch, return false.
            return false;
        }

        var mid = (currentNode == p || currentNode == q);

        var left = recurseTree(currentNode.left, p, q);    // Left Recursion. If left recursion returns true, set left = 1 else 0
        var right = recurseTree(currentNode.right, p, q);   // Right Recursion

        if ((mid && (left || right)) || (left && right)) { // If any two of the flags left, right or mid become True
            LCA = currentNode; // root ve çocuklardan birisi true ise yada left&right aynı anda true
        }

        // Return true if any one of the three bool values is True.
        return (mid || left || right);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return LCA;
    }
}