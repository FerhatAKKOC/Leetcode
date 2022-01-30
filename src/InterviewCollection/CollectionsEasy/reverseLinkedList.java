package InterviewCollection.CollectionsEasy;

import InterviewCollection.ListNode;

public class reverseLinkedList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode.print(head);
        head = reverseList(head);
        ListNode.print(head);
    }

    private static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;

        while (curr != null) {

            next = curr.next;
            curr.next = prev;
            prev=curr;
            curr= next;
        }

        return prev;
    }
}
