package InterviewCollection.Recursions;

import InterviewCollection.ListNode;
import InterviewCollection.TreeNode;

public class ConvertDLLtoBST {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        head = pushAtTail(head, 2);
        head = pushAtTail(head, 3);
        head = pushAtTail(head, 4);
        head = pushAtTail(head, 5);
        head = pushAtTail(head, 6);
        head = pushAtTail(head, 7);

        ListNode.print(head);

    }

    TreeNode head = null;

    private static TreeNode ConvertDLLtoBST(ListNode head) {

        int n = countDLLNumber(head);

        return ConvertDLLtoBSTRecursion(n);
    }

    private static TreeNode ConvertDLLtoBSTRecursion(int n) {

        /*
        if (n <= 0)
            return null;

        TreeNode left = ConvertDLLtoBSTRecursion(n / 2);

        // head_ref now refers to middle node, make middle node as root of BST
        TreeNode root = head;

        root.left = left;

        //Change head pointer of Linked List for parent recursive calls
        head = head.right;

        // right subtree =  NumOfNodes: Total nodes - nodes in left subtree - 1 (for root)
        root.right = ConvertDLLtoBSTRecursion(n - n / 2 - 1);
        return root;
        */
        return null;
    }


    private static int countDLLNumber(ListNode head) {

        int count = 0;
        var ref = head;

        while (ref != null) {
            count++;
            ref = ref.next;
        }

        return count;
    }

    /* Function to insert a node at the beginning of
     the Doubly Linked List */
    private static ListNode pushAtTail(ListNode head, int val) {
        var node = new ListNode(val);

        if (head == null)
            return node;
        else {

            var ref = head;

            while (ref.next != null)
                ref = ref.next;

            node.prev = ref;
            ref.next = node;

            return head;
        }
    }
}
