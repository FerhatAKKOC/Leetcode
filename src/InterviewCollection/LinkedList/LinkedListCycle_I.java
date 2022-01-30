package InterviewCollection.LinkedList;

import InterviewCollection.ListNode;

public class LinkedListCycle_I {

    public static void main(String[] args) {

        ListNode cycle = new ListNode(2);
        ListNode node1 = new ListNode(0, new ListNode(-4, cycle));
        cycle.next = node1;

        var head = new ListNode(3, cycle);

        ListNode.print(head);

        System.out.println("Output: " + hasCycle(head));
    }

    private static boolean hasCycle(ListNode head) {

        if (head == null || head.next == null)
            return false;

        if (head.next.next == head)
            return true;

        var slow = head;
        var fast = head.next;

        while (fast.next!=null){

            slow = slow.next;

            fast = fast.next;

            if(fast == slow) return true;

            if(fast.next!=null)
                fast = fast.next;

            if(fast == slow) return true;
        }

        return false;
    }


}
