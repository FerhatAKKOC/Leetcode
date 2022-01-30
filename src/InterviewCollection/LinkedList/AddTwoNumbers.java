package InterviewCollection.LinkedList;

import InterviewCollection.ListNode;

public class AddTwoNumbers {
    public static void main(String[] args) {

        var l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        var l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        var head = addTwoNumbers(l1, l2);
        ListNode.print(head);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        int carry = 0;

        while (l1 != null || l2 != null) {

            if (l1 != null && l2 != null) {

                int sum = (l1.val + l2.val + carry);
                carry = sum / 10;
                head = pushAtTail(head, new ListNode(sum % 10));
                l1 = l1.next;
                l2 = l2.next;
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
