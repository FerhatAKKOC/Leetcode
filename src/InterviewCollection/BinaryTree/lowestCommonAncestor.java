package InterviewCollection.BinaryTree;


import InterviewCollection.TreeNode;

import java.util.Stack;

public class lowestCommonAncestor {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3,
                new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
                new TreeNode(1, new TreeNode(0), new TreeNode(8)));


//        lowestCommonAncestor(root, new TreeNode(5), new TreeNode(0));
        System.out.println("Output : " + lowestCommonAncestor(root, new TreeNode(6), new TreeNode(8)).val);
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        var curr = root;
        var searched = p;
        TreeNode LCA = null;
        int size = 0;

        while (!stack.isEmpty() || curr != null) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            if (stack.size() < size) {
                LCA = curr;
                size = stack.size();
            }

            if (curr.val == searched.val) {
                if (searched == q)
                    break;
                size = stack.size();
                LCA = curr;
                searched = q;
            }

//            System.out.print(curr.val + " -> ");
            curr = curr.right;
        }


        return LCA;
    }


}

class lowestCommonAncestor2 {

    private TreeNode ans;

    public lowestCommonAncestor2() {
        this.ans = null; // Variable to store LCA node.
    }

    private boolean recursiveTree(TreeNode curr, TreeNode p, TreeNode q) {

        if (curr == null) {  // If reached the end of a branch, return false.
            return false;
        }

        var mid = (curr.val == p.val || curr.val == q.val);

        var left = this.recursiveTree(curr.left, p, q);    // Left Recursion. If left recursion returns true, set left = 1 else 0
        var right = this.recursiveTree(curr.right, p, q);   // Right Recursion

        if ((left && right) || (mid && (left || right))) {  // çocukların her ikisi birden TRUE ise, yada curr ve herhngi bir child TRUE ise, curr is LCA
            this.ans = curr;
        }

        return (mid || left || right); // Return true if any one of the three bool values is True.
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        this.recursiveTree(root, p, q);
        return this.ans;
    }
}
