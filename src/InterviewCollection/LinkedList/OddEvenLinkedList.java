package InterviewCollection.LinkedList;

import InterviewCollection.ListNode;

public class OddEvenLinkedList {
    public static void main(String[] args) {

        var head = new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(7)))))));
        ListNode.print(head);
        var out = oddEvenList(head);
        ListNode.print(out);
    }

    private static ListNode oddEvenList(ListNode head) {

        var even = head;
        var odd = head.next;
        var oddHead = odd;

        while (odd != null || even != null) {

            if (odd != null) {
                even.next = odd.next;
                even = even.next;
            }
            if (even != null && odd != null) {
                odd.next = even.next;
                odd = odd.next;
            } else {
                even.next = oddHead;
                break;
            }
        }
        return head;
    }

    //****************************************************
    //****************************************************
    //The first node is considered odd, and the second node is even, and so on.

    public ListNode oddEvenList2(ListNode head) {

        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}













