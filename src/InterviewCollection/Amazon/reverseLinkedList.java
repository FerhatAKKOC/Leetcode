package InterviewCollection.Amazon;

import InterviewCollection.ListNode;

public class reverseLinkedList {

    public static void main(String[] args) {
        var head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode.print(head);
        head = reverseList(head);
        ListNode.print(head);
    }

    /*
        Reverse Linked List
     */
    private static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode head_new = null;

        while (head != null) {

            var nextNode = head.next;
            head.next = head_new;
            head_new = head;

            head = nextNode;
        }

        return head_new;
    }
}
