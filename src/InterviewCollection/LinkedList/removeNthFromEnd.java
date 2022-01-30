package InterviewCollection.LinkedList;

import InterviewCollection.ListNode;

public class removeNthFromEnd {

    public static void main(String[] args) {

        var head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode.print(head);
        var output = removeNthFromEnd(head, 5);
        ListNode.print(output);
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {

        var ref = head;

        int len = 1;

        while (ref.next != null) {
            len++;
            ref = ref.next;
        }
        if (len == n){  // remove head
            return head.next;
        }

        len -= n + 1;
        ref = head;

        while (ref != null && len > 0) {
            ref = ref.next;
            len--;
        }

        if (ref != null && ref.next != null)
            ref.next = ref.next.next;

        return head;
    }

    //*********************************************************
    //*********************************************************
    public ListNode removeNthFromEnd1(ListNode head, int n) {

       ListNode dummy = new ListNode(0);

        dummy.next = head;
        int length = 0;
        ListNode first = head;

        while (first != null) {
            length++;
            first = first.next;
        }

        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }
}
