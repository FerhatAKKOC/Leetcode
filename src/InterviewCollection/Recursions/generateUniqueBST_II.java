package InterviewCollection.Recursions;

import InterviewCollection.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class generateUniqueBST_II {

    public static void main(String[] args) {
        var output = generateTrees(3);
    }

    private static List<TreeNode> generateTrees(int n) {
        if (n < 1)
            return new ArrayList<>();
        return generateTrees(1, n);
    }

    private static List<TreeNode> generateTrees(int low, int high) {

        List<TreeNode> res = new ArrayList<>();
        if (low > high) {
            res.add(null);
            return res;
        }

        if (low == high) {
            res.add(new TreeNode(low));
            return res;
        }

        for (int i = low; i <= high; i++) {  // 1, 2, 3

            var leftSubtree = generateTrees(low, i - 1);
            var rightSubtree = generateTrees(i + 1, high);

            for (var left : leftSubtree)
                for (var right : rightSubtree) {
                    var root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
        }


        return res;
    }
}
