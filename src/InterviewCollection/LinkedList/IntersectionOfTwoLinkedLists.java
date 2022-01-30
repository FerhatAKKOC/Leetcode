package InterviewCollection.LinkedList;

import InterviewCollection.ListNode;

import java.util.HashSet;

public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {

        var intersect = new ListNode(8, new ListNode(4, new ListNode(5)));
        var headA = new ListNode(4, new ListNode(1, intersect));
        var headB = new ListNode(5, new ListNode(6, new ListNode(1, intersect)));

        var out = getIntersectionNode(headA, headB);

        if (out != null)
            System.out.println("Output : " + out.val);

    }

    /*
     * Burada kritik nokta, aynı anda intersect kısmına değmeleri. Bunun içinde tail'e gelince diğer'inin head'i atanmalıdır.
     * */
    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while (a != b) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    //*********************************************************
    //*********************************************************
    private static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        ListNode n1 = headA;
        ListNode n2 = headB;

        // define hashset
        HashSet<ListNode> hs = new HashSet<>();
        while (n1 != null) {
            hs.add(n1);
            n1 = n1.next;
        }
        while (n2 != null) {
            if (hs.contains(n2)) {
                return n2;
            }
            n2 = n2.next;
        }
        return null;
    }
}
