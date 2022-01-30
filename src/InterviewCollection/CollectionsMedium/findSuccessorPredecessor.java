package InterviewCollection.CollectionsMedium;

import InterviewCollection.TreeNode;

public class findSuccessorPredecessor {

    public static void main(String[] args) {

        var root = new TreeNode(20,
                new TreeNode(8, new TreeNode(4), new TreeNode(12, new TreeNode(10), new TreeNode(14))),
                new TreeNode(22));

        findPreSuc(root, 22);

        System.out.println("predecessor: " + ((predecessor != null) ? predecessor.val : "NULL") + "     successor: " + ((successor != null) ? successor.val : "NULL"));

    }

    private static TreeNode predecessor = null;
    private static TreeNode successor = null;


    private static void findPreSuc(TreeNode root, int key) {

        // Base case
        if (root == null)
            return;

        // If key is present at root
        if (root.val == key) {

            // The maximum value in left
            if (root.left != null) {
                var tmp = root.left;
                while (tmp.right != null)
                    tmp = tmp.right;

                predecessor = tmp;
            }

            // The minimum value in
            if (root.right != null) {
                var tmp = root.right;

                while (tmp.left != null)
                    tmp = tmp.left;

                successor = tmp;
            }
            return;
        }

        if (root.val > key) {           // root's key, go to left subtree
            successor = root;
            findPreSuc(root.left, key);
        } else {                        // Go to right subtree
            predecessor = root;
            findPreSuc(root.right, key);
        }
    }
}

/*
1. If root is NULL
      then return
2. if key is found then
    a. If its left subtree is not null
        Then predecessor will be the right most
        child of left subtree or left child itself.
    b. If its right subtree is not null
        The successor will be the left most child
        of right subtree or right child itself.
    return
3. If key is smaller then root node
        set the successor as root
        search recursively into left subtree
    else
        set the predecessor as root
        search recursively into right subtree
 */
