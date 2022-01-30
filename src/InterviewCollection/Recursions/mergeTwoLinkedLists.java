package InterviewCollection.Recursions;

import InterviewCollection.ListNode;

public class mergeTwoLinkedLists {


    public static void main(String[] args) {

//        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l1 = new ListNode(1, new ListNode(2));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode.print(l1);
        ListNode.print(l2);

        var output = mergeTwoLists(l1, l2);

        ListNode.print(output);
    }

    // recursive solution
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /*  Iteratively
        private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {


        ListNode ref = null;

        while (l1 != null || l2 != null) {

            if ((l1 != null && l2 != null) && (l1.val <= l2.val)) {

                ListNode curr = l1;
                l1 = l1.next;
                curr.next = null;
                ref = pushAtTail(ref, curr);

            } else {
                ListNode curr = l2;
                l2 = l2.next;
                curr.next = null;
                ref = pushAtTail(ref, curr);
            }
            ListNode.printList(ref);
        }

        return ref;
    }

    static ListNode pushAtTail(ListNode head, ListNode node) {
        if (head == null)
            head = node;
        else {
            var ref = head;
            while (ref.next != null) {
                ref = ref.next;
            }
            ref.next = node;
        }
        return head;
    }
     */
}
