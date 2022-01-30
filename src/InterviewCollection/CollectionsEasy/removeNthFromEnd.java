package InterviewCollection.CollectionsEasy;

import InterviewCollection.ListNode;

public class removeNthFromEnd {

    public static void main(String[] args) {

        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode.print(root);
        root = removeNthFromEnd(root, 1);
        ListNode.print(root);

    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null || n == 0) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        var first = head;
        int numOfNodes = 0;

        while (first != null) {
            numOfNodes++;
            first = first.next;
        }

        if (n == numOfNodes) return head.next;

        numOfNodes -= n;

        System.out.println("numOfNodes: " + numOfNodes);

        first = dummy;
        while (numOfNodes > 0) {
            numOfNodes--;
            first = first.next;
        }

        first.next = first.next.next;

        return dummy.next;
    }
}
