package InterviewCollection.Recursions;

import InterviewCollection.TreeNode;

import java.util.ArrayDeque;

public class isSameTree {

    public static void main(String[] args) {

        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        System.out.println("Output : " + isSameTree(p, q));
    }

    // Recursive solutions
    private static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // Iterative Solutions
    public boolean isSameTree2(TreeNode p, TreeNode q) {

        if (!check(p, q)) return false;

        ArrayDeque<TreeNode> pQueue = new ArrayDeque<>();
        ArrayDeque<TreeNode> qQueue = new ArrayDeque<>();

        pQueue.addLast(p);
        qQueue.addLast(q);

        while (!qQueue.isEmpty()) {

            var pRef = pQueue.removeFirst();
            var qRef = qQueue.removeFirst();

            if (!check(pRef.left, qRef.left)) return false;
            if (!check(pRef.right, qRef.right)) return false;

            if (pRef.left != null) {    // in Java nulls are not allowed in Deque
                pQueue.addLast(pRef.left);
                qQueue.addLast(qRef.left);
            }
            if (pRef.right != null) {
                pQueue.addLast(pRef.right);
                qQueue.addLast(qRef.right);
            }
        }

        return true;
    }


    private static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;    // p and q are null
        if (p == null || q == null) return false;    // one of p and q is null
        if (p.val != q.val) return false;
        return true;
    }

}
