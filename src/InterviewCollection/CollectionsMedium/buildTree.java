package InterviewCollection.CollectionsMedium;

import InterviewCollection.TreeNode;

import java.util.stream.IntStream;

public class buildTree {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        var root = buildTree(preorder, inorder);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        var out = buildTree(preorder, inorder, 0, inorder.length - 1);
        return out;
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {

        // Base Case
        if (start > end)
            return null;
        if (start == end)
            return new TreeNode(inorder[start]);

        int val = preorder[start];
        var root = new TreeNode(val);

        int i = findIndex(inorder, val);

        root.left = buildTree(preorder, inorder, start, i - 1);
        root.right = buildTree(preorder, inorder, i + 1, end);

        return root;
    }

    private static int findIndex(int[] arr, int t) {
        int len = arr.length;
        return IntStream.range(0, len)
                .filter(i -> t == arr[i])
                .findFirst() // first occurrence
                .orElse(-1); // No element found
    }
}
