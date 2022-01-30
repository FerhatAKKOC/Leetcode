package InterviewCollection.BinaryTree;

import InterviewCollection.TreeNode;

public class BinaryTree {

    TreeNode root = null;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(int value) {
        this.root = new TreeNode(value);
    }

    public static TreeNode insert(TreeNode root, int value) {

        var node = new TreeNode(value);

        if (root == null) return node;

        if (root.val < value) {
            root.right = insert(root.right, value);
        } else if (root.val > value) {
            root.left = insert(root.left, value);
        }

        return root;
    }

    public static TreeNode search(TreeNode root, int value) {

        if (root == null || root.val == value) return root;

        if (value > root.val) { // rigth
            return search(root.right, value);
        } else {
            return search(root.left, value);
        }
    }

    // for Binary Search Three
    public static int min(TreeNode root) {
        while (root.left != null)
            root = root.left;

        return root.val;
    }

    // for Binary Search Three
    public static int max(TreeNode root) {
        while (root.right != null)
            root = root.right;
        return root.val;
    }

    public static TreeNode delete(TreeNode root, int key) {

        if (root == null) return null;

        if (root.val < key)
            return delete(root.right, key);
        else if (root.val > key) {
            return delete(root.left, key);
        } else {

            if (root.left == null && root.right == null)  //leaf node
                return null;

            if (root.right != null) {
                root.val = min(root.right);
                root.right = delete(root.right, min(root.right));
                return root;
            } else if (root.left != null) {
                root.val = max(root.left); // left subTree deki en büyük değer ile, sileceğimiz değeri yer değiştiriyoruz.
                root.left = delete(root.left, max(root.left)); // yer değiştirilen değeride subtree den siliyoruz.
                return root;
            }
        }
        return root;
    }

    /******  Herhangi bir Binary Tree  *****************/

    public static int findMax(TreeNode root) {

        if (root == null) return Integer.MAX_VALUE;
        int val = root.val;
        int lres = findMax(root.left);
        int rres = findMax(root.right);

        return Math.max(lres,rres);
    }

    public static int findMin(TreeNode root) {

        if (root == null) return Integer.MIN_VALUE;
        int val = root.val;
        var lres = findMin(root.left);
        var rres = findMin(root.right);

        return Math.min(lres,rres);
    }
    //**************************************************


    public static void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(" " + root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(" " + root.val);
        inOrder(root.right);
    }

    public static void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(" " + root.val);
    }
}
