package InterviewCollection.LinkedList;

import InterviewCollection.ListNode;

public class RotateList {

    public static void main(String[] args) {

        ListNode head = new ListNode(8, new ListNode(4, new ListNode(88, new ListNode(5, new ListNode(6, new ListNode(1))))));
        ListNode.print(head);
        head = rotateList(head, 3);
        ListNode.print(head);

    }

    private static ListNode rotateList(ListNode head, int i) {

        if (head == null || head.next == null)
            return head;

        for (int j = 0; j < i; j++) {
            head = rotateRight(head);
        }
        return head;
    }

    private static ListNode rotateRight(ListNode head) {

        var ref = head;

        while (ref.next.next != null)
            ref = ref.next;

        var last = ref.next;
        ref.next = null;

        last.next = head;
        return last;
    }
}
