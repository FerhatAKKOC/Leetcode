package InterviewCollection.CollectionsMedium;

import InterviewCollection.ListNode;

public class getIntersectionNode {

    public static void main(String[] args) {

        ListNode intersect = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode A = new ListNode(4, new ListNode(1, intersect));
        ListNode B = new ListNode(5, new ListNode(6, new ListNode(1, intersect)));

        var output = getIntersectionNode(A, B);

        if (output != null)
            System.out.println("Output: " + output.val);

    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headA == null) return null;

        var a = headA;
        var b = headB;

        while (a != b) {
            a = a.next != null ? a.next : headB;
            b = b.next != null ? b.next : headA;
        }

        return a;

    }
}
