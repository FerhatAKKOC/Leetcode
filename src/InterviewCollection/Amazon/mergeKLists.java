package InterviewCollection.Amazon;

import InterviewCollection.ListNode;

import java.util.PriorityQueue;

public class mergeKLists {

    public static void main(String[] args) {

    }

    /*
        Merge k Sorted Lists
     */
    private static ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (var list : lists) {        // Bir tane Priority Queue içerisine değerleri dolduruyoruz.
            var ref = list;
            while (ref != null) {
                pq.add(ref.val);
                ref = ref.next;
            }
        }

        var head = new ListNode(0);
        var ref = head;

        while (!pq.isEmpty()) {
            ref.next = new ListNode(pq.poll());
            ref = ref.next;
        }

        return head.next;
    }

}
