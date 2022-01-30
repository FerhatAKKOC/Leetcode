package InterviewCollection.LinkedList;

import InterviewCollection.ListNode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        var head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode.print(head);
        ListNode.print(reverseList(head));
    }

    private static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode next = null;
        ListNode current = head;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;

    }
}
