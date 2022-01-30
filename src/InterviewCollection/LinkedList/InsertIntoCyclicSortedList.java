package InterviewCollection.LinkedList;

import InterviewCollection.ListNode;

public class InsertIntoCyclicSortedList {

    public static void main(String[] args) {

        var head = new ListNode(3);
        var node = new ListNode(7, new ListNode(9, new ListNode(11, head)));
        head.next = node;

        head = insertIntoCCL(head, new ListNode(12));

        ListNode.print(head);
    }

    private static ListNode insertIntoCCL(ListNode head, ListNode node) {

        if (head == null) return node;

        var ref = head;

        while (true) {
            if (ref.val < node.val && node.val < ref.next.val)
                break;
            else if (ref.val > ref.next.val) {
                if (ref.val < node.val)
                    break;
            }
            ref = ref.next;
        }
        node.next = ref.next;
        ref.next = node;
        return head;
    }

}
