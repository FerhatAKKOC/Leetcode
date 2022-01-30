package InterviewCollection.LinkedList;

import InterviewCollection.ListNode;

public class MergeTwoSortedLists {


    public static void main(String[] args) {

        var l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        var l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        var out = mergeTwoLists(l1, l2);
        ListNode.print(out);
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = null;

        while (l1 != null || l2 != null) {

            if ((l1 != null && l2 != null) && (l1.val < l2.val)) {

                ListNode curr = l1;
                l1 = l1.next;
                curr.next = null;
                head = pushAtTail(head, curr);

            } else if ((l1 != null && l2 != null)) {
                ListNode curr = l2;
                l2 = l2.next;
                curr.next = null;
                head = pushAtTail(head, curr);

            } else if (l1 == null && l2 != null) {
                ListNode curr = l2;
                l2 = l2.next;
                curr.next = null;
                head = pushAtTail(head, curr);

            } else if (l1 != null && l2 == null) {
                ListNode curr = l1;
                l1 = l1.next;
                curr.next = null;
                head = pushAtTail(head, curr);
            }
        }

        return head;
    }

    private static ListNode pushAtTail(ListNode head, ListNode curr) {
        if (head == null) {
            head = curr;
        } else {
            var ref = head;
            while (ref.next != null)
                ref = ref.next;
            ref.next = curr;
        }
        return head;
    }
}
