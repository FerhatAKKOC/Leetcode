package InterviewCollection.Amazon;

import InterviewCollection.ListNode;

public class mergeTwoSortedLists {

    public static void main(String[] args) {

        var l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        var l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        var head = mergeTwoLists(l1, l2);

        ListNode.print(head);
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = null;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                var next = l1.next;
                l1.next = null;
                head = addAtTail(head, l1);
                l1 = next;
            } else {
                var next = l2.next;
                l2.next = null;
                head = addAtTail(head, l2);
                l2 = next;
            }
        }

        if (l1 != null) {
            head = addAtTail(head, l1);
        } else if (l2 != null)
            head = addAtTail(head, l2);

        return head;
    }

    private static ListNode addAtTail(ListNode head, ListNode node) {

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
