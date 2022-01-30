package InterviewCollection.BinaryTree;

import InterviewCollection.TreeNode;

import java.util.*;

public class SerializationDeserialization {

    public static void main(String[] args) {
        // Let us construct a tree shown in the above figure


//        // Let us deserialize the storeed tree into root1
//        TreeNode t = deserialize(serialized);
//
//        System.out.println("Inorder Traversal of the tree constructed from serialized String:");
//        inorder(t);
    }

    private static String serialize(TreeNode root) {

        if (root == null) return null;
        List<String> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (stack.size() > 0) {

            var temp = stack.pop();
            list.add(temp.val + "");

            if (temp.right != null)
                stack.push(temp.right);
            else
                list.add("#");

            if (temp.left != null)
                stack.push(temp.left);
            else
                list.add("#");
        }

        return String.join(",", list);
    }


    static int t;

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null) return null;
        String[] arr = data.split(",");
        t = 0;

        return helper(arr);
    }

    static int index = 0;

    public static TreeNode helper(String[] arr) {

        if (arr[index] == "#") return null;

        TreeNode root = new TreeNode(Integer.parseInt(arr[index]));

        index++;
        root.left = helper(arr);
        index++;
        root.right = helper(arr);

        return root;
    }

    // A simple inorder traversal used for testing the
    // constructed tree
    static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }


    //*********************************** 2. Çözüm  *****************************************
    private String serialize_(TreeNode root) {

        if (root == null) return "#";
        String leftSerialized = serialize_(root.left);
        String rigthSerialized = serialize_(root.right);

        String serial = root.val + "," + leftSerialized + "," + rigthSerialized;

        return serial;
    }

    private TreeNode deserialize_(String s) {

        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(s.split(",")));

        return deserializeHelper_(queue);
    }

    private TreeNode deserializeHelper_(Queue<String> queue) {

        String s = queue.poll();
        if (s.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(s));

        root.left = deserializeHelper_(queue);
        root.right = deserializeHelper_(queue);

        return root;
    }
}
