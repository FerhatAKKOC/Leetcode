package InterviewCollection.LinkedList;

import InterviewCollection.ListNode;

public class RemoveLinkedListElements {

    public static void main(String[] args) {

        var head = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));

        ListNode.print(head);
        removeElements(head, 6);
        ListNode.print(head);
    }

    private static ListNode removeElements(ListNode head, int val) {

        if (head == null) return null;
        if (head.next == null && head.val == val) return null;

        ListNode dummy = new ListNode(0, head);

        ListNode ref = dummy;

        while (ref != null && ref.next != null) {
            if (ref.next.val == val) {
                ref.next = ref.next.next;
            } else {
                ref = ref.next;
            }
        }

        return dummy.next;
    }
}
