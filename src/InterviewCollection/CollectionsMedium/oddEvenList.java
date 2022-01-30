package InterviewCollection.CollectionsMedium;

import InterviewCollection.ListNode;

public class oddEvenList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));

        var odd = oddEvenList(head);
        ListNode.print(odd);
    }

    /*
        Input: head = [2,1,3,5,6,4,7]
        Output: [2,3,6,7,1,5,4]
     */
    private static ListNode oddEvenList(ListNode head) {

        var odd = head;
        var even = head.next;
        var evenHead = even;

        while (odd != null && even != null) {

            odd.next = even.next;
            if (odd.next != null) {
                odd = odd.next;
                even.next = odd.next;
            }
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }
}
