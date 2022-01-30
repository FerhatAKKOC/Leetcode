package InterviewCollection.HashTable;

import InterviewCollection.TreeNode;

import java.util.*;

public class findDuplicateSubtrees {
    public static void main(String[] args) {

    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        postorder(root, map, result);
        return result;
        
    }

    public String postorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> result) {

        if (cur == null)
            return "#";

        String left = postorder(cur.left, map, result);
        String right = postorder(cur.right, map, result);

        String serial = cur.val + "," + left + "," + right;

        map.put(serial, map.getOrDefault(serial, 0) + 1);

        if (map.get(serial) == 2)
            result.add(cur);

        return serial;
    }
}
