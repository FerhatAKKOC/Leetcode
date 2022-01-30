package InterviewCollection.BinaryTree;

import InterviewCollection.TreeNode;

import java.util.Arrays;

public class buildBinaryTreeFromInOrder_PostOrder {

    public static void main(String[] args) {
        int in[] = new int[]{9, 3, 15, 20, 7};
        int post[] = new int[]{9, 15, 7, 20, 3};
        var root = buildTree(in, post);

        inorder(root);
    }

    // Construct Binary Tree from Inorder and Postorder Traversal
    private static TreeNode buildTree(int[] in, int[] post) {

        if (post.length == 0) return null;
        if (post.length == 1) return new TreeNode(post[0]);

        int rootVal = post[post.length - 1];
        var root = new TreeNode(rootVal);

        var leftArr = Arrays.copyOfRange(in, 0, findIndex(in, rootVal));    // in ve post'u ayrı ayrı tekrar yaratığ fonksiyona geri dönüyoruz.
        var rightArr = Arrays.copyOfRange(post, 0, leftArr.length);
        root.left = buildTree(leftArr, rightArr);

        leftArr = Arrays.copyOfRange(in, findIndex(in, rootVal) + 1, in.length);
        rightArr = Arrays.copyOfRange(post, post.length - 1 - leftArr.length, post.length - 1);
        root.right = buildTree(leftArr, rightArr);

        return root;
    }

    //*******************************************************************
    //*******************************************************************
    private static TreeNode buildTree2(int[] inorder, int[] postorder) {

        return buildTree_(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private static TreeNode buildTree_(int[] in, int[] post, int inStart, int inEnd, int postStart, int postEnd) {

        if (inStart > inEnd)
            return null;

        var node = new TreeNode(post[postEnd]);

        if (inStart == inEnd)
            return node;

        int index = findIndex(in, node.val);

        node.left = buildTree_(in, post, inStart, index - 1, postStart, postStart - inStart + index - 1);
        node.right = buildTree_(in, post, index + 1, inEnd, postEnd - inEnd + index, postEnd - 1);

        return node;
    }

    //*******************************************************************
    private static int findIndex(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) return i;
        }
        return -1;
    }

    private static void inorder(TreeNode root) {

        if (root == null) return;
        inorder(root.left);
        System.out.print(" " + root.val);
        inorder(root.right);
    }
}
