package InterviewCollection.CollectionsHard;

import InterviewCollection.ListNode;

public class mergeKSortedLists {

    public static void main(String[] args) {

        ListNode[] list = new ListNode[3];

        list[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        list[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        list[2] = new ListNode(2, new ListNode(6));

//        var out = mergeKLists(list);

        ListNode head = null;

        head = addNode(head, new ListNode(14));
        ListNode.print(head);
        head = addNode(head, new ListNode(6));
        ListNode.print(head);
        head = addNode(head, new ListNode(3));
        ListNode.print(head);
        head = addNode(head, new ListNode(5));
        ListNode.print(head);
        head = addNode(head, new ListNode(7));
        ListNode.print(head);
        head = addNode(head, new ListNode(18));
        ListNode.print(head);
    }

    private static ListNode mergeKLists(ListNode[] lists) {


        ListNode head = null;

        var minNode = new ListNode(Integer.MAX_VALUE);

        return null;
    }


    private static ListNode addNode(ListNode head, ListNode node) {

        if (head == null) {  // null ise
            return node;
        }
        var ref = head;
        while (ref.next != null) {
            ref = ref.next;
        }

        node.prev = ref;
        ref.next = node;

        return head;

/*        if (node.val < head.val) { // en başa ekliyor
            node.next = head;
            head.prev = node;
            return node;
        }

        var ref = head;
        while (ref != null) {   // araya ekliyor.
            if (node.val < ref.val) {
                node.next = ref;
                node.prev = ref.prev;
                ref.prev.next = node;
                ref.prev = node;
                return head;
            }
            ref = ref.next;
        }*/

    }
}
