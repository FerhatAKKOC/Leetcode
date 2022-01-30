package InterviewCollection.CollectionsEasy;

import InterviewCollection.ListNode;

public class linkedListCycle {

    public static void main(String[] args) {


        ListNode node2 = new ListNode(2);
        ListNode cycle = new ListNode(0, new ListNode(-4, node2));
        node2.next = cycle;
        ListNode head = new ListNode(3, node2);

        ListNode.print(head);

        System.out.println("Output : " + hasCycle(head));
    }

    private static boolean hasCycle(ListNode head) {

        if (head == null || head.next == null)
            return false;

        var ref = head;

        ListNode low = head;
        ListNode fast = head.next;

        while (fast.next != null) {

            if (low == fast) return true;

            if (fast.next != null) fast = fast.next;
            if (low == fast) return true;

            if (fast.next != null) fast = fast.next;
            if (low == fast) return true;

            if (low.next != null) low = low.next;

        }

        return false;
    }
}
