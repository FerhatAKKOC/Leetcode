package InterviewCollection.Amazon;

import InterviewCollection.ListNode;

public class reverseKGroup {

    public static void main(String[] args) {

        var head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        head = reverseKGroup(head, 3);
        ListNode.print(head);
    }

    /*
        Reverse Nodes in k-Group
     */
    private static ListNode reverseKGroup(ListNode head, int k) {

        if (k == 1)
            return head;

        var ref = head;

        for (int i = 1; i < k; i++) {
            ref = ref.next;
        }
        var remaining = ref.next;
        ref.next = null;
        head = reverse(head);

        var ref1 = head;
        while (ref1.next != null)
            ref1 = ref1.next;
        ref1.next = remaining;

        return head;
    }

    private static ListNode reverse(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode head_new = null;

        while (head != null) {
            var nextNode = head.next;
            head.next = head_new;
            head_new = head;
            head = nextNode;
        }

        return head_new;
    }
}
