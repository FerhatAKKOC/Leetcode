package InterviewCollection.Recursions;

import InterviewCollection.TreeNode;

public class ConvertArray2BST {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        var root = sortedArrayToBST(arr, 0, n - 1);
        System.out.println("Preorder traversal of constructed BST");
        tree.preOrder(root);
    }

    //  SortedArray to BST Sorted Array
    private static TreeNode sortedArrayToBST(int[] arr, int start, int end) {

        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2; /* Get the middle element and make it root */
        TreeNode node = new TreeNode(arr[mid]);
        node.left = sortedArrayToBST(arr, start, mid - 1);
        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }
}
