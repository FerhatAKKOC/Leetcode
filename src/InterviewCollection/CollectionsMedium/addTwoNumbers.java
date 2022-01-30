package InterviewCollection.CollectionsMedium;

import InterviewCollection.ListNode;

public class addTwoNumbers {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(6)));

        ListNode sum = addTwoNumbers(l1, l2);
        ListNode.print(sum);


    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int residual = 0;

        ListNode sum = null;

        while (l1 != null || l2 != null) {

            if ((l1 != null && l2 != null)) {
                int val = l1.val + l2.val + residual;
                sum = pushBack(sum, val % 10);
                residual = val / 10;
                l1 = l1.next;
                l2 = l2.next;
            }
        }

        if (residual != 0)
            sum = pushBack(sum, residual);

        return sum;
    }

    private static ListNode pushBack(ListNode head, int val) {

        if (head == null)
            return new ListNode(val);

        var ref = head;

        while (ref.next != null) {
            ref = ref.next;
        }

        ref.next = new ListNode(val);
        return head;
    }
}
