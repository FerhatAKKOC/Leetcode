package InterviewCollection.CollectionsEasy;

import InterviewCollection.ListNode;

public class mergeTwoSortedLists {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))));

        var out = mergeTwoLists(l1, l2);
        ListNode.print(out);

    }

    /*
        Merge Two Sorted Lists
     */
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) return l1;
        if (l2 == null) return l1;
        if (l1 == null) return l2;

        ListNode ref = null;

        while (l1 != null || l2 != null) {

            if (l1 != null && l2 != null) {

                if (l2.val < l1.val) {
                    var next = l2.next;
                    l2.next = null;
                    ref = addAtTail(ref, l2);
                    l2 = next;
                } else {
                    var next = l1.next;
                    l1.next = null;
                    ref = addAtTail(ref, l1);
                    l1 = next;
                }
            } else if (l1 != null) {
                ref = addAtTail(ref, l1);
                l1 = null;

            } else if (l2 != null) {

                ref = addAtTail(ref, l2);
                l2 = null;
            }
        }

        return ref;
    }

    private static ListNode addAtTail(ListNode ref, ListNode node) {

        if (ref == null) return node;

        var temp = ref;

        while (temp.next != null)
            temp = temp.next;
        temp.next = node;

        return ref;
    }
}
