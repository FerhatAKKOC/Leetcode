package InterviewCollection.BinaryTree;

import InterviewCollection.TreeNode;

public class maxDepth {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        System.out.println("Output : " + maxDepth(root));
    }

    // bottom-up solution
    private static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // top-down solution
    private static int answer =0;
    private static int maxDepth2(TreeNode root, int depth) {

        if (root == null) return answer;
        if(depth> answer) answer = depth;

        maxDepth2(root.left,depth+1);
        maxDepth2(root.right,depth+1);

        return answer;
    }
}
