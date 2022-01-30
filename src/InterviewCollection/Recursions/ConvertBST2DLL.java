package InterviewCollection.Recursions;

import InterviewCollection.ListNode;
import InterviewCollection.TreeNode;

public class ConvertBST2DLL {


    // Convert BST to Sorted Doubly Linked List
    public static void main(String[] args) {

        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(7)), new TreeNode(13));

        ListNode head = null;
        head = InOnder(root, head);
        System.out.println();
        ListNode.print(head);
    }

    private static ListNode InOnder(TreeNode root, ListNode head) {

        if (root == null)
            return head;

        head = InOnder(root.left, head);
//        System.out.print(root.val + " -> ");
        head = pushAtTail(head,root);
        head = InOnder(root.right, head);

        return head;
    }

    private static ListNode pushAtTail(ListNode head, TreeNode node) {

        if (head == null) {
            head = new ListNode(node.val);
            return head;
        }

        var ref = head;

        while (ref.next != null) {
            ref = ref.next;
        }

        var listNode = new ListNode(node.val, ref, null);
        ref.next = listNode;

        return head;
    }

}
