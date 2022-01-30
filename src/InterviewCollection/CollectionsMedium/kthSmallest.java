package InterviewCollection.CollectionsMedium;

import InterviewCollection.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class kthSmallest {

    public static void main(String[] args) {

        var root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));

        System.out.println("Output: " + kthSmallest(root, 1));
    }

    private static int kthSmallest(TreeNode root, int k) {

        if (root == null) return -1;

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;


        while (curr != null || !s.isEmpty()) {

            /* Reach the left most Node of the curr Node */
            while (curr != null) {
                s.push(curr);       // sadece left'leri stack'e atmamız yeterlidir.
                curr = curr.left;
            }
            curr = s.pop(); /* Current must be NULL at this point */
            //System.out.print(curr.val + " ");
            list.add(curr.val);
            curr = curr.right;    /* we have visited the node and its left subtree.  Now, it's right subtree's turn */
        }
        return list.get(k-1);
    }
}
