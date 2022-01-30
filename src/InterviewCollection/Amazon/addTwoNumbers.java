package InterviewCollection.Amazon;

import InterviewCollection.ListNode;

public class addTwoNumbers {

    public static void main(String[] args) {

        var l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        var l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        var head = addTwoNumbers(l1, l2);

        ListNode.print(head);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int residual = 0;
        ListNode head = null;

        while (l1 != null || l2 != null) {

            if ((l1 != null && l2 != null)) {
                var sum = l1.val + l2.val + residual;
                head = addAtTail(head, sum % 10);
                residual = sum / 10;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                var sum = l1.val + residual;
                head = addAtTail(head, sum % 10);
                residual = sum / 10;
                l1 = l1.next;
            } else if (l2 != null) {
                var sum = l2.val + residual;
                head = addAtTail(head, sum % 10);
                residual = sum / 10;
                l2 = l2.next;
            }
        }
        if (residual > 0)
            head = addAtTail(head, residual);
        return head;
    }

    private static ListNode addAtTail(ListNode head, int value) {

        var node = new ListNode(value);

        if (head == null)
            return node;

        var ref = head;
        while (ref.next != null) {
            ref = ref.next;
        }
        ref.next = node;
        return head;
    }
}
