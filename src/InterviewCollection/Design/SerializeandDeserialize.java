package InterviewCollection.Design;

import InterviewCollection.TreeNode;

public class SerializeandDeserialize {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));

        preOrder(root);
        System.out.println();
        var serilization = serialize(root);
        System.out.println("Seriliziation: " + serilization);

        var output = deserialize(serilization);
        preOrder(root);

    }

    // Encodes a tree to a single string.
    private static String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();

        helperSerialize(root, sb);

        return sb.toString();
    }


    // Decodes your encoded data to tree.
    private static TreeNode deserialize(String data) {

        if (data == null || data.charAt(0) == '#') return null;

        TreeNode root = new TreeNode(Integer.valueOf(data.charAt(0)));

        root.left = deserialize(data.substring(1));
        root.right = deserialize(data.substring(2));

        return root;

    }

    private static void helperSerialize(TreeNode root, StringBuilder sb) {

        if (root == null) {
            sb.append("#");
            return;
        }
//        System.out.print(root.val + " -> ");
        sb.append(String.valueOf(root.val));
        helperSerialize(root.left, sb);
        helperSerialize(root.right, sb);
    }

    private static void preOrder(TreeNode root) {

        if (root == null) return;

        System.out.print(root.val + " -> ");

        preOrder(root.left);
        preOrder(root.right);
    }
}
