package InterviewCollection.Recursions;

import InterviewCollection.ListNode;

public class reverseLinkedList {


    public static void main(String[] args) {

        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode.print(root);
        var output = reverseList(root);
        ListNode.print(output);

    }

    private static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;

    }
}















