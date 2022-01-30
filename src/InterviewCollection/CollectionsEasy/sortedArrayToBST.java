package InterviewCollection.CollectionsEasy;

import InterviewCollection.TreeNode;

public class sortedArrayToBST {

    public static void main(String[] args) {
//        int[] nums = {-10, -3, 0, 5, 9};
//        int[] nums = {1, 3};
        int[] nums = {1, 2, 3, 4, 5, 6, 7};


        var root = sortedArrayToBST(nums);

        InOrder(root);

    }

    private static TreeNode sortedArrayToBST(int[] nums) {

        return sortedArrayToBST(nums, 0, nums.length - 1);

    }

    private static TreeNode sortedArrayToBST(int[] nums, int start, int end) {

        // base
        if ((end - start) == 1) return new TreeNode(nums[start], null, new TreeNode(nums[end]));
        if ((end - start) == 0) return new TreeNode(nums[start]);

        var mid = (end + start) / 2;  // Toplama olduğuna dikkat et

        var root = new TreeNode(nums[mid]);

        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);

        return root;
    }

    // Second solution
    private static TreeNode sortedArrayToBST2(int[] arr, int start, int end) {

        if (start > end)
            return null;

        int mid = (start + end) / 2; /* Get the middle element and make it root */
        TreeNode node = new TreeNode(arr[mid]);
        node.left = sortedArrayToBST(arr, start, mid - 1);
        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }


    private static void InOrder(TreeNode root) {

        if (root == null) return;

        InOrder(root.left);
        System.out.print(root.val + " -> ");
        InOrder(root.right);
    }
}
