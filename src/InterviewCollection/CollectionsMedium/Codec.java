package InterviewCollection.CollectionsMedium;


import InterviewCollection.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Serialize and Deserialize Binary Tree
public class Codec {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
//        preOrder(root);

        var encoded = serialize(root);
        System.out.println(encoded);
        var decoded = deserialize(encoded);

//        preOrder(decoded);

    }

    // Encodes a tree to a single string.
    private static String serialize(TreeNode root) {

        if (root == null)
            return "#";

        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    //***********************************************************
    //***********************************************************
    // Decodes your encoded data to tree.
    private static TreeNode deserialize(String data) {

        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));

        return deserializeHelper_(queue);
    }

    private static TreeNode deserializeHelper_(Queue<String> queue) {

        String s = queue.poll();

        if (s.equals("#")) return null;

        TreeNode root = new TreeNode(Integer.valueOf(s));

        root.left = deserializeHelper_(queue);
        root.right = deserializeHelper_(queue);

        return root;
    }

    private static void preOrder(TreeNode root) {

        if (root == null)
            return;

        System.out.print(root.val + " -> ");

        preOrder(root.left);
        preOrder(root.right);
    }
}
