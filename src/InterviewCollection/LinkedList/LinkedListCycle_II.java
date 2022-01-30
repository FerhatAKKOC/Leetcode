package InterviewCollection.LinkedList;

import InterviewCollection.ListNode;

public class LinkedListCycle_II {

    public static void main(String[] args) {

        ListNode node = new ListNode(2);
        ListNode node1 = new ListNode(0, new ListNode(-4, node));
        node.next = node1;

        ListNode head = new ListNode(3, node);



        System.out.println("Output : " + hasCycle(head));

    }

    private static int hasCycle(ListNode head) {

        if (head == null || head.next == null) return -1;
        if (head == head.next.next) return 0;

        ListNode node = null;

        var slow = head;
        var fast = head.next;

        while (fast.next != null) {

            slow = slow.next;
            fast = fast.next;

            if (fast == slow) { node = fast; break;}

            if (fast.next != null)
                fast = fast.next;

            if (fast == slow) { node = fast; break;}
        }

        int index = -1;

        if (node != null) {
            var ref = head;

            while (ref.next != null) {

                if (ref == node)
                    break;

                index++;
                ref = ref.next;
            }
        }

        return index;
    }
}
